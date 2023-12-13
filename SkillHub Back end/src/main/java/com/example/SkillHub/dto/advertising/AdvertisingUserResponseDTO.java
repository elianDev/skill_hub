package com.example.SkillHub.dto.advertising;

import com.example.SkillHub.entities.Advertising;

import java.time.Instant;

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
