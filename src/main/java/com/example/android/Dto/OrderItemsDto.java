package com.example.android.Dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemsDto {
    private Long id;
    private Long orderId;
    private Long productId;
    private Integer quantity;
    private Double price;
}
