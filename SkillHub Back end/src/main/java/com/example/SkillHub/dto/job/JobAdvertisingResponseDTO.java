package com.example.SkillHub.dto.job;

import com.example.SkillHub.dto.category.CategoryResponseDTO;
import com.example.SkillHub.entities.Advertising;
import com.example.SkillHub.entities.Category;
import com.example.SkillHub.entities.Job;

import java.util.HashSet;
import java.util.Set;

public record JobAdvertisingResponseDTO(Long id,
                                        String name,
                                        String description,
                                        Set<CategoryResponseDTO> categories) {

    public JobAdvertisingResponseDTO(Job job) {
        this(
                job.getId(),
                job.getName(),
                job.getDescription(),
                new HashSet<>()
        );
    }

    public JobAdvertisingResponseDTO(Job job, Set<Category> categories, Set<Advertising> advertisings) {
        this(job);
        categories.forEach(cat -> this.categories.add(new CategoryResponseDTO(cat)));
    }
}
