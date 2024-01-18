package com.example.api.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.api.domain.Customer;
import com.example.api.dto.CustomerFilterDTO;

public interface CustomerService {
    public Page<Customer> findAll(CustomerFilterDTO filter, Pageable pageable);
	public Optional<Customer> findById(Long id);
	public Customer createCustomer(Customer customer);
    public Customer updateCustomer(Long id, Customer updatedCustomer);
    public void deleteCustomer(Long id);
}
