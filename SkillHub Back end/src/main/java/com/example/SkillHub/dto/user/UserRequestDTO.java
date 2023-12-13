package com.example.SkillHub.dto.user;

import com.example.SkillHub.dto.advertising.AdvertisingUserResponseDTO;
import com.example.SkillHub.entities.Advertising;
import com.example.SkillHub.entities.User;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public record UserRequestDTO(String name, String email, String password, LocalDate birthDate, String phone) {
}
