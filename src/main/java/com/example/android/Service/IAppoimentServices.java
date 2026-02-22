package com.example.android.Service;

import com.example.android.Entity.Products;

import java.util.List;

public interface IAppoimentServices {



    Products findByName(String name);
    Products getById(Long id);
    boolean update(Long id, Products updated);


}
