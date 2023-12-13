package com.example.SkillHub.dto.user;

import java.time.LocalDate;

public record UserRequestDTO(String name, String email, String password, LocalDate birthDate, String phone) {
}
