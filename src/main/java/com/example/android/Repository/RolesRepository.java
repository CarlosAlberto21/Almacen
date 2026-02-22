package com.example.android.Repository;

import com.example.android.Entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolesRepository extends JpaRepository<Roles, Long> {
    // Cambia findByRol por findByName
    // Es vital poner <Roles> para que Java sepa qué objeto devuelve el Optional
    Optional<Roles> findByName(String name);
}
