package com.example.SkillHub.dto.review;

import com.example.SkillHub.entities.enums.StarRate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ReviewRequestDTO(@NotBlank(message = "Campo requerido")
                               @Size(min = 10, message = "No mínimo 10 caracteres")
                               String text,
                               StarRate starRate) {
}
