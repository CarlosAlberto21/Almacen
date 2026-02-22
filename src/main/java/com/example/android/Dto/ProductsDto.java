package com.example.android.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductsDto {

    private String name;
    private String brand;
    private String model;
    private String sku;
    private String description;
    private String type;
    private Long supplierId;
}
