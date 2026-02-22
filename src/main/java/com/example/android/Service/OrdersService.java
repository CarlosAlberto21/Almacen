package com.example.android.Service;

import com.example.android.Dto.OrdersDto;
import com.example.android.Entity.Customers;
import com.example.android.Entity.Orders;
import com.example.android.Entity.Suppliers;
import com.example.android.Repository.CustomersRepository;
import com.example.android.Repository.OrdersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService implements IOrdersService {

    private final OrdersRepository repository;
    private  final  CustomersRepository customersRepository;

    public OrdersService(OrdersRepository repository, CustomersRepository customersRepository) {
        this.repository = repository;
        this.customersRepository = customersRepository;
    }

    @Override
    public List<OrdersDto> getAll() {
        return repository.findAll().stream().map(order -> {
            OrdersDto dto = new OrdersDto();
            dto.setId(order.getId());
            dto.setOrder_date(order.getOrder_date());
            dto.setStatus(order.getStatus());
            dto.setTotal(order.getTotal());

            dto.setCustomerId(order.getCustomer().getId());
            if (order.getCustomer() != null) {
                dto.setCustomerId(order.getCustomer().getId());
            }
            return dto;
        }).toList();
    }

    @Override
    public void save(OrdersDto dto) {
        Orders  o = new Orders();
        o.setTotal(dto.getTotal());
        o.setStatus(dto.getStatus());

        if(dto.getCustomerId()!=null){
            Customers c = customersRepository.findById(dto.getCustomerId())
                    .orElseThrow(() -> new RuntimeException("Customer no existe"));
            o.setCustomer(c);
        }
        repository.save(o);
    }
}
