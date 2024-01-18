package com.example.api.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.api.domain.Address;
import com.example.api.repository.AddressRepository;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressRepository addressRepository;

    private final WebClient webClient;

    public AddressServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://viacep.com.br").build();
    }

    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    public Address findByCep(String cep) {
        String url = "/ws/" + cep + "/json/";

        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(Address.class)
                .block(); 
    }

    public Address save(Address address) {
        return addressRepository.save(address);
    }
}

