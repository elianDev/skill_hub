package com.example.SkillHub.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record UserRequestDTO(@NotBlank(message = "Campo requerido")
                             @Size(min = 3, max = 80, message = "Nome precisa ter de 3 a 80 caracteres ")
                             String name,

                             @Email
                             @NotBlank(message = "Campo requerido")
                             String email,

                             @NotBlank(message = "Campo requerido")
                             @Size(min = 4, message = "Senha precisa ter no mínimo 4 caracteres")
                             String password,

                             @Past
                             LocalDate birthDate,

                             @NotBlank(message = "Campo requerido")
                             @Size(min = 11, max = 11, message = "Número deve ter 11 caracteres com DDD")
                             String phone) {
}
