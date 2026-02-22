package com.example.android.Controller;



import com.example.android.Dto.ProductsDto;
import com.example.android.Dto.SuppliersDto;
import com.example.android.Service.IProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductsControllers {
    @Autowired
    private IProductsService service;

    @GetMapping("/get")
    public List<ProductsDto> get() {
        return service.getAll();
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody ProductsDto products) {
         service.save(products);
         return ResponseEntity.ok("Producto creado correctamente");
    }
}
