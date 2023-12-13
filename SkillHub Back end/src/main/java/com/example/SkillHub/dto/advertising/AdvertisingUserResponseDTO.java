package com.example.SkillHub.dto.advertising;

import com.example.SkillHub.dto.job.JobResponseDTO;
import com.example.SkillHub.dto.review.ReviewResponseDTO;
import com.example.SkillHub.dto.user.UserResponseDTO;
import com.example.SkillHub.entities.Advertising;
import com.example.SkillHub.entities.Review;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public record AdvertisingUserResponseDTO(Long id,
                                         String title,
                                         String description,
                                         Double price,
                                         Instant createdAt,
                                         Instant updatedAt,
                                         String imgUrl
                                     ) {

    public AdvertisingUserResponseDTO(Advertising advertising) {
        this(
                advertising.getId(),
                advertising.getTitle(),
                advertising.getDescription(),
                advertising.getPrice(),
                advertising.getCreatedAt(),
                advertising.getUpdatedAt(),
                advertising.getImgUrl()
        );
    }
}
