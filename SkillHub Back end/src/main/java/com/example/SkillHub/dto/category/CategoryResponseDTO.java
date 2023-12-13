package com.example.SkillHub.dto.category;

import com.example.SkillHub.entities.Category;

public record CategoryResponseDTO(Long id,
                                  String name,
                                  String description) {

    public CategoryResponseDTO(Category category) {
        this(
                category.getId(),
                category.getName(),
                category.getDescription()
        );
    }
}
