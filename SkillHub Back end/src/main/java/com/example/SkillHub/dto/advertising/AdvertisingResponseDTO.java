package com.example.SkillHub.dto.advertising;

import com.example.SkillHub.dto.job.JobAdvertisingResponseDTO;
import com.example.SkillHub.dto.job.JobResponseDTO;
import com.example.SkillHub.dto.review.ReviewResponseDTO;
import com.example.SkillHub.dto.user.SellerResponseDTO;
import com.example.SkillHub.dto.user.UserResponseDTO;
import com.example.SkillHub.entities.Advertising;
import com.example.SkillHub.entities.Review;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public record AdvertisingResponseDTO(Long id,
                                     String title,
                                     String description,
                                     Double price,
                                     Instant createdAt,
                                     Instant updatedAt,
                                     String imgUrl,
                                     List<ReviewResponseDTO> reviews,
                                     JobAdvertisingResponseDTO job,
                                     SellerResponseDTO seller
                                     ) {

    public AdvertisingResponseDTO(Advertising advertising) {
        this(
                advertising.getId(),
                advertising.getTitle(),
                advertising.getDescription(),
                advertising.getPrice(),
                advertising.getCreatedAt(),
                advertising.getUpdatedAt(),
                advertising.getImgUrl(),
                new ArrayList<>(),
                new JobAdvertisingResponseDTO(advertising.getJob()),
                new SellerResponseDTO(advertising.getSeller())
        );
    }

    public AdvertisingResponseDTO(Advertising advertising, List<Review> reviews) {
        this(advertising);
        reviews.forEach(review -> this.reviews.add(new ReviewResponseDTO(review)));
    }
}
