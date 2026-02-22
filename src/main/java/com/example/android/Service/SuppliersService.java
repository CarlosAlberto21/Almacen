package com.example.android.Service;

import com.example.android.Dto.SuppliersDto;
import com.example.android.Entity.Suppliers;

import com.example.android.Repository.SuppliersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuppliersService implements ISuppliersService {


    private final SuppliersRepository repository;

    public SuppliersService(SuppliersRepository repository) {
        this.repository = repository;
    }
    @Override
    public List<SuppliersDto> getAll() {
        // Ejemplo simple: mapear entities a DTO
        return repository.findAll().stream().map(s -> {
            SuppliersDto dto = new SuppliersDto();
            dto.setId(s.getId());
            dto.setName(s.getName());
            dto.setContact(s.getContact());
            dto.setPhone(s.getPhone());
            dto.setEmail(s.getEmail());
            dto.setRating(s.getRating());
            return dto;
        }).toList();
    }

    @Override
    public void save(SuppliersDto dto) {
        Suppliers s = new Suppliers(); // ENTITY
        s.setName(dto.getName());
        s.setContact(dto.getContact());
        s.setPhone(dto.getPhone());
        s.setEmail(dto.getEmail());
        s.setRating(dto.getRating());

        repository.save(s);
    }
}
