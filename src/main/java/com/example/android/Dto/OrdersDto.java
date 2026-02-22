package com.example.android.Dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class OrdersDto {
    private Long id;
    private LocalDateTime order_date;
    private Long customerId;
    private String status;
    private BigDecimal total;

}
