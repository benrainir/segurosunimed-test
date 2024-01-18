package com.example.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.mapstruct.Mapper;

@Data
@Mapper
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressDTO {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
}
