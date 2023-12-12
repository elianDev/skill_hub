package com.example.SkillHub.dto.user;

import com.example.SkillHub.dto.advertising.AdvertisingResponseDTO;
import com.example.SkillHub.entities.Advertising;
import com.example.SkillHub.entities.User;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public record UserResponseDTO(Long id,
                              String name,
                              String email,
                              LocalDate birthDate,
                              String phone,
                              Instant createdAt,
                              List<AdvertisingResponseDTO> advertisings) {

    public UserResponseDTO(User user) {
        this(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getBirthDate(),
                user.getPhone(),
                user.getCreatedAt(),
                new ArrayList<>()
        );
    }

    public UserResponseDTO(User user, List<Advertising> advertisings) {
        this(user);
        advertisings.forEach(ad -> this.advertisings.add(new AdvertisingResponseDTO(ad)));
    }
}
