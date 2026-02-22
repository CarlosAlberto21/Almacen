package com.example.android.Controller;

import com.example.android.Dto.LoginRequest;
import com.example.android.Dto.LoginResponse;
import com.example.android.Dto.RegisterRequest;
import com.example.android.Service.AuthService;
import com.example.android.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {


    private final AuthService authService;
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {

        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        userService.registerNewUser(request);
        return ResponseEntity.ok("Usuario creado correctamente");
    }


}
