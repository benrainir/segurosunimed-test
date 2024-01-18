package com.example.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerFilterDTO {
    private String name;
    private String email;
    private String gender;
    private String city;
    private String state;
}
