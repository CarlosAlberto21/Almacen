package com.example.android.Service;

import com.example.android.Repository.CustomersRepository;
import com.example.android.Repository.OrdersRepository;
import org.springframework.stereotype.Service;

@Service
public class OrdersItemService {
    private final OrdersRepository repository;
    private  final CustomersRepository customersRepository;

    public OrdersService(OrdersRepository repository, CustomersRepository customersRepository) {
        this.repository = repository;
        this.customersRepository = customersRepository;
    }
}
