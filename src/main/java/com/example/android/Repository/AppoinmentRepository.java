package com.example.android.Repository;

import com.example.android.Entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppoinmentRepository extends JpaRepository<Products, Long> {


}
