package com.example.android.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "suppliers")
public class Suppliers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

    @Column(length = 100)
    private String contact;

    @Column(length = 20)
    private String phone;

    @Column(length = 50)
    private String email;

    @Column(nullable = false)
    private Integer rating = 0;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();

    // Constructor vacío
    public Suppliers() {}

    // Constructor con todos los campos excepto id
    public Suppliers(String name, String contact, String phone, String email, Integer rating) {
        this.name = name;
        this.contact = contact;
        this.phone = phone;
        this.email = email;
        this.rating = rating;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @OneToMany(mappedBy = "suppliers", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Products> products;
}
