package com.example.android.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomersDto {
    private Long id;
    private String name;
    private String type; // taller, mecánico, particular
    private String phone;
    private String email;
    private List<Object> orders; // Se podría tipar con el DTO correspondiente si existe


}
