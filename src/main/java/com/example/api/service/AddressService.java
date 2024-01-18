package com.example.api.service;

import java.util.List;

import com.example.api.domain.Address;

public interface AddressService {
    public List<Address> findAll();
    public Address findByCep(String cep);
    public Address save(Address address);
}
