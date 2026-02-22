package com.example.android.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
//@UniqueConstraint(columnNames = "sku") le dice que ese campo debe ser único
@Table(name = "products",
        uniqueConstraints = @UniqueConstraint(columnNames = "sku"))
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String brand;

    private String model;

    @Column(nullable = false, unique = true)
    private String sku;

    private String type; // repuesto, accesorio, consumible

    private String description;

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt = LocalDateTime.now();


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    private Suppliers suppliers;


    // Relación con inventario
    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<Inventory> inventoryList;
}