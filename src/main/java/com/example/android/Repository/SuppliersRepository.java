package com.example.android.Repository;

import com.example.android.Entity.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuppliersRepository  extends JpaRepository<Suppliers, Long> {
}
