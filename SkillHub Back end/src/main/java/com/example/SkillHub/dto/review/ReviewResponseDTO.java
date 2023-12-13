package com.example.SkillHub.dto.review;

import com.example.SkillHub.entities.Review;
import com.example.SkillHub.entities.enums.StarRate;

import java.time.Instant;

public record ReviewResponseDTO(Long id,
                                String text,
                                Instant createdAt,
                                StarRate starRate) {

    public ReviewResponseDTO(Review review) {
        this(
                review.getId(),
                review.getText(),
                review.getCreatedAt(),
                review.getStarRate()
        );
    }
}
