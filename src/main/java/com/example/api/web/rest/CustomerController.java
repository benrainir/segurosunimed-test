package com.example.api.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import com.example.api.domain.Customer;
import com.example.api.dto.CustomerDTO;
import com.example.api.dto.CustomerFilterDTO;
import com.example.api.service.CustomerService;

import mapper.CustomerMapper;

@RestController
@RequestMapping("/customers")
public class CustomerController {

   private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

	@GetMapping
    public Page<Customer> findAll(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String gender,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String state,
			@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
                CustomerFilterDTO filter = new CustomerFilterDTO();
                filter.setName(name);
                filter.setEmail(email);
                filter.setGender(gender);
                filter.setCity(city);
                filter.setState(state);
                return customerService.findAll(filter, PageRequest.of(page, size));
    }


	@GetMapping("/{id}")
	public Customer findById(@PathVariable Long id) {
		return customerService.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));
	}

	// Endpoint para criar um novo cliente
    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {
        CustomerDTO createdCustomer = customerService.createCustomer(customerDTO);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    // Endpoint para editar um cliente existente
    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
        CustomerDTO updatedCustomer = customerService.updateCustomer(id, customerDTO);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }

    // Endpoint para excluir um cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
