package com.example.android.Service;

import com.example.android.Dto.CustomersDto;
import com.example.android.Entity.Customers;


import java.util.List;

public interface ICustomersService {
    List<CustomersDto> getAll();
    void save(CustomersDto customer);
}
