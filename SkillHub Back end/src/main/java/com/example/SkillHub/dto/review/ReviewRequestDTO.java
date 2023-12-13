package com.example.SkillHub.dto.review;

import com.example.SkillHub.entities.enums.StarRate;

public record ReviewRequestDTO(String text, StarRate starRate) {
}
