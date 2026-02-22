package com.example.android.Service;

import com.example.android.Dto.OrderItemsDto;

import java.util.List;

public interface IOrdersItemService {
    List<OrderItemsDto> getAll();
    void save(OrderItemsDto products);
}
