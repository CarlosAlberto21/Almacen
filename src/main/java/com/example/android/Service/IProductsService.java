package com.example.android.Service;

import com.example.android.Dto.ProductsDto;


import java.util.List;

public interface IProductsService {
    // Método GET
    List<ProductsDto> getAll();
    void save(ProductsDto products);

}
