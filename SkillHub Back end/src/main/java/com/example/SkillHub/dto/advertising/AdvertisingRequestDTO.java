package com.example.SkillHub.dto.advertising;

public record AdvertisingRequestDTO(String title,
                                    String description,
                                    Double price,
                                    String imgUrl,
                                    Long jobId,
                                    Long sellerId) {
}
