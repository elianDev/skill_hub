package com.example.SkillHub.dto.user;

import com.example.SkillHub.entities.User;

import java.time.Instant;
import java.time.LocalDate;

public record SellerResponseDTO(Long id,
                                String name,
                                String email,
                                LocalDate birthDate,
                                String phone,
                                Instant createdAt) {

    public SellerResponseDTO(User user) {
        this(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getBirthDate(),
                user.getPhone(),
                user.getCreatedAt()
        );
    }
}
