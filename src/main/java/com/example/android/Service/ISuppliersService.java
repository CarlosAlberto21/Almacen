package com.example.android.Service;


import com.example.android.Dto.SuppliersDto;
import com.example.android.Entity.Suppliers;

import java.util.List;

public interface ISuppliersService {

    List<SuppliersDto> getAll();

    void save(SuppliersDto customer);

}
