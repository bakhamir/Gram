package com.example.messenger.controller;

import com.example.messenger.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestParam String phoneNumber, @RequestParam String password) {
        String token = authService.register(phoneNumber, password);
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String phoneNumber, @RequestParam String password) {
        return authService.login(phoneNumber, password)
                .map(token -> ResponseEntity.ok(new AuthResponse(token)))
                .orElseGet(() -> ResponseEntity.status(401).body("Invalid credentials"));
    }
}

