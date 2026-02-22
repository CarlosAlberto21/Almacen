package com.example.android.Service;

import com.example.android.Dto.LoginRequest;
import com.example.android.Dto.LoginResponse;
import com.example.android.Dto.RegisterRequest;
import com.example.android.Entity.Roles;
import com.example.android.Entity.User;
import com.example.android.Repository.RolesRepository;
import com.example.android.Repository.UserRepository;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    //Aqui registramo eel usuario

    @Autowired
    private RolesRepository rolesRepository;

    @Transactional // Importante: asegura que se guarde en ambas tablas o en ninguna
    public void registerNewUser(RegisterRequest dto) {
        // 1. Crear la instancia de la entidad
        User newUser = new User();
        newUser.setUsername(dto.getUsername());
        newUser.setPassword(passwordEncoder.encode(dto.getPassword())); // Cifrado

        // 2. Buscar el rol en la DB
        Roles role = rolesRepository.findByName(dto.getRol())
                .orElseThrow(() -> new RuntimeException("Error: El rol no existe."));

        // 3. Asignar el rol al Set del usuario
        newUser.getRoles().add(role);

        // 4. Guardar el usuario (esto dispara la inserción en la tabla intermedia)
        userRepository.save(newUser);
    }


}
