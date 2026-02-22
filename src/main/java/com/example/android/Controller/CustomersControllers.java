package com.example.android.Controller;

import com.example.android.Dto.CustomersDto;
import com.example.android.Entity.Customers;

import com.example.android.Service.ICustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/customer")
public class CustomersControllers {
    @Autowired
    private ICustomersService service;

    @GetMapping("/get")
    public List<CustomersDto> get() {
        return service.getAll();
    }

    @PostMapping("/save")
    public void save(CustomersDto customer) {
        service.save(customer);
    }
}
