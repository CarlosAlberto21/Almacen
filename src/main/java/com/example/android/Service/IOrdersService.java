package com.example.android.Service;

import com.example.android.Dto.OrdersDto;



import java.util.List;

public interface IOrdersService {
    List<OrdersDto> getAll();
    void save(OrdersDto products);
}
