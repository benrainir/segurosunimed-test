package com.example.api.dto;

import lombok.Data;
import org.mapstruct.Mapper;

@Data
@Mapper
public class CustomerFilterDTO {
    private String name;
    private String email;
    private String gender;
    private String city;
    private String state;
}
