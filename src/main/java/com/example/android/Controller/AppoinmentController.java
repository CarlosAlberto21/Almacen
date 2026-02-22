package com.example.android.Controller;

/*
import com.example.android.Entity.Products;
import com.example.android.Service.IAppoimentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appoinment")
public class AppoinmentController {
    @Autowired
    private IAppoimentServices service;



    // Traer cita por id
    @GetMapping("/get/id/{id}")
    public Products getById(@PathVariable Long id) {
        return service.getById(id); // tu service devuelve un Appoiment
    }

    // Traer cita por id
    @GetMapping("/get/name/{name}")
    public Products getName(@PathVariable String name) {
        return service.findByName(name); // tu service devuelve un Appoiment
    }

    @PostMapping("/save")
    public void save(@RequestBody Products apo) {
        service.save(apo);
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable Long id, @RequestBody Products apo) {
        boolean updated = service.update(id, apo); // ✅ aquí va el método update
        if (updated) {
            return "Actualizado ✅";
        } else {
            return "Cita no encontrada ❌";
        }
    }
}
*/