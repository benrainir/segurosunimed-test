package com.example.api.service;

import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.data.domain.Pageable;

import com.example.api.domain.Address;
import com.example.api.domain.Customer;
import com.example.api.dto.CustomerDTO;
import com.example.api.dto.CustomerFilterDTO;
import com.example.api.exception.ResourceNotFoundException;
import com.example.api.filter.CustomerSpecification;
import com.example.api.repository.CustomerRepository;

import mapper.CustomerMapper;

@Service
@Validated
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

	
    @Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

	public Page<Customer> findAll(CustomerFilterDTO filter, Pageable pageable) {
        return customerRepository.findAll(CustomerSpecification.filterBy(filter), pageable);
    }

	public Optional<Customer> findById(Long id) {
		return customerRepository.findById(id);
	}

	public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = customerMapper.toEntity(customerDTO);
        List<Address> addresses = customer.getAddresses();

        // Garante que cada endereço esteja associado ao cliente
        if (addresses != null) {
            for (Address address : addresses) {
                address.setCustomer(customer);
            }
        }

        Customer savedCustomer = customerRepository.save(customer);
        return customerMapper.toDTO(savedCustomer);
    }

    public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) {
        Customer customer = customerMapper.toEntity(customerDTO);
        if (customerRepository.existsById(id)) {
            customer.setId(id);
            Customer savedCustomer = customerRepository.save(customer);
            return customerMapper.toDTO(savedCustomer);
        } else {
            throw new ResourceNotFoundException("Customer not found with id: " + id);
        }
    }

    public void deleteCustomer(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Customer not found with id: " + id);
        }
    }
	

}
