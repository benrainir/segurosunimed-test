package com.example.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.data.domain.Pageable;
import com.example.api.domain.Customer;
import com.example.api.dto.CustomerFilterDTO;
import com.example.api.exception.ResourceNotFoundException;
import com.example.api.filter.CustomerSpecification;
import com.example.api.repository.CustomerRepository;

@Service
@Validated
public class CustomerServiceImpl implements CustomerService {

    @Autowired
	private CustomerRepository repository;

	
	public CustomerServiceImpl(CustomerRepository repository) {
		this.repository = repository;
	}

	public Page<Customer> findAll(CustomerFilterDTO filter, Pageable pageable) {
        return repository.findAll(CustomerSpecification.filterBy(filter), pageable);
    }

	public Optional<Customer> findById(Long id) {
		return repository.findById(id);
	}

	public Customer createCustomer(Customer customer) {
        return repository.save(customer);
    }

    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        if (repository.existsById(id)) {
            updatedCustomer.setId(id);
            return repository.save(updatedCustomer);
        } else {
            throw new ResourceNotFoundException("Customer not found with id: " + id);
        }
    }

    public void deleteCustomer(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Customer not found with id: " + id);
        }
    }
	

}
