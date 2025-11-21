package com.fiap.futureskills.dto;

import com.fiap.futureskills.domain.user.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AuthDTOs {

    public record LoginRequest(
        @NotBlank(message = "Email is required")
        @Email(message = "Invalid email format")
        String email,
        
        @NotBlank(message = "Password is required")
        String password
    ) {}

    public record RegisterRequest(
        @NotBlank(message = "Name is required")
        String name,
        
        @NotBlank(message = "Email is required")
        @Email(message = "Invalid email format")
        String email,
        
        @NotBlank(message = "Password is required")
        String password,
        
        @NotNull(message = "Role is required")
        Role role
    ) {}

    public record TokenResponse(
        String token
    ) {}
}
