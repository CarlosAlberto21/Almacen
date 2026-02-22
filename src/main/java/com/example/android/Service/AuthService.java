package com.example.android.Service;

import com.example.android.Dto.LoginRequest;
import com.example.android.Dto.LoginResponse;
import com.example.android.Entity.User;
import com.example.android.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository repository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public LoginResponse login(LoginRequest request) {

        User user = repository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Password incorrecto");
        }

        String token = jwtService.generateToken(user.getId(), user.getUsername());

        return new LoginResponse(token, user.getId(), user.getUsername());
    }

}
