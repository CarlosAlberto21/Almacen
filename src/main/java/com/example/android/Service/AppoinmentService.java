package com.example.android.Service;
/*
import com.example.android.Entity.Products;
import com.example.android.Repository.AppoinmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppoinmentService implements IAppoimentServices {

    @Autowired
    AppoinmentRepository repository;





    @Override
    public void save(Products customer) {

        // Busca citas que coincidan
        List<Products> conflicts = repository.findByDateAndHora(customer.getDate(), customer.getHora());

        if (!conflicts.isEmpty()) {
            throw new RuntimeException("Ya existe una cita en esa fecha y hora");
        }

        repository.save(customer);
    }

    @Override
    public Products findByName(String name) {
        return repository.findByName(name).orElse(null);
    }

    @Override
    public Products getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public boolean update(Long id, Products updated) {
        return repository.findById(id).map(existing -> {
            existing.setName(updated.getName());
            existing.setNumero(updated.getNumero());
            existing.setDate(updated.getDate());
            existing.setHora(updated.getHora());
            repository.save(existing);
            return true;

        }).orElse(false);
    }
}
*/