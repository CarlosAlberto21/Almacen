package com.example.android.Controller;


import com.example.android.Dto.SuppliersDto;
import com.example.android.Service.ISuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suppliers")
public class SuppliersController {

    @Autowired
    ISuppliersService  service;

    @GetMapping("/get")
    public List<SuppliersDto> get() {
        return service.getAll();
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody SuppliersDto suppliers) {
        service.save(suppliers);
        return ResponseEntity.ok("Suppliers creado correctamente");
    }

}
