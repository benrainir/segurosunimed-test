package com.example.api.dto;

import java.util.List;
import org.mapstruct.Mapper;
import lombok.Data;

@Data
@Mapper
public class CustomerDTO {
    private String name;
    private String email;
    private String gender;
    private List<AddressDTO> addresses;
}
