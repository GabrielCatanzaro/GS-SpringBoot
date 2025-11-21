package com.fiap.futureskills.controller;

import com.fiap.futureskills.dto.AuthDTOs;
import com.fiap.futureskills.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthDTOs.TokenResponse> register(
            @RequestBody @Valid AuthDTOs.RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthDTOs.TokenResponse> authenticate(
            @RequestBody @Valid AuthDTOs.LoginRequest request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
