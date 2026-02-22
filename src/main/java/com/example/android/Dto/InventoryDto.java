package com.example.android.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InventoryDto {
    private Long id;
    private Long productId;
    private Long locationId;
    private Integer quantity;
    private Integer minStock;
    private Integer maxStock;
}
