package com.example.android.Service;

import com.example.android.Dto.ProductsDto;
import com.example.android.Entity.Products;
import com.example.android.Entity.Suppliers;
import com.example.android.Repository.ProductsRepository;
import com.example.android.Repository.SuppliersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductsService implements IProductsService{


    private final ProductsRepository repository;
    private final SuppliersRepository supplierRepo;



    public ProductsService(ProductsRepository repository, SuppliersRepository supplierRepo) {
        this.repository = repository;
        this.supplierRepo = supplierRepo;
    }

    @Override
        public List<ProductsDto> getAll() {
            List<Products> productsList = repository.findAll();

            // Convertimos Products a ProductsDto
            return productsList.stream().map(product -> {
                ProductsDto dto = new ProductsDto();
                dto.setName(product.getName());
                dto.setBrand(product.getBrand());
                dto.setModel(product.getModel());
                dto.setSku(product.getSku());
                dto.setType(product.getType());
                dto.setDescription(product.getDescription());
                if (product.getSuppliers() != null) {
                    dto.setSupplierId(product.getSuppliers().getId());
                }
                return dto;
            }).collect(Collectors.toList());
        }
        @Override
        public void save(ProductsDto dto){
            Products p = new Products();
            p.setName(dto.getName());
            p.setBrand(dto.getBrand());
            p.setModel(dto.getModel());
            p.setSku(dto.getSku());
            p.setType(dto.getType());
            p.setDescription(dto.getDescription());

            if(dto.getSupplierId()!=null){
                Suppliers s = supplierRepo.findById(dto.getSupplierId())
                        .orElseThrow(() -> new RuntimeException("Supplier no existe"));
                p.setSuppliers(s);
            }

            repository.save(p);
        }
}
