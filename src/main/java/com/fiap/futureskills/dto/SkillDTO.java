package com.fiap.futureskills.dto;

import jakarta.validation.constraints.NotBlank;

public record SkillDTO(
    Long id,
    
    @NotBlank(message = "Name is required")
    String name,
    
    String description,
    
    @NotBlank(message = "Category is required")
    String category
) {}
