package com.example.android.Controller;

import com.example.android.Dto.OrdersDto;
import com.example.android.Service.IOrdersService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/order")
public class OrdersController {


    private final IOrdersService service;

    public OrdersController(IOrdersService service) {
        this.service = service;
    }

    @GetMapping("/get")
    public List<OrdersDto> get() {
        return service.getAll();
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody OrdersDto orders) {
        service.save(orders);
        return ResponseEntity.ok("Orden creado correctamente");
    }
}
