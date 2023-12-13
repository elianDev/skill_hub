package com.example.SkillHub.dto.job;

import com.example.SkillHub.dto.advertising.AdvertisingResponseDTO;
import com.example.SkillHub.dto.advertising.AdvertisingUserResponseDTO;
import com.example.SkillHub.dto.category.CategoryResponseDTO;
import com.example.SkillHub.entities.Advertising;
import com.example.SkillHub.entities.Category;
import com.example.SkillHub.entities.Job;

import java.util.HashSet;
import java.util.Set;

public record JobResponseDTO(Long id,
                             String name,
                             String description,
                             Set<CategoryResponseDTO> categories,
                             Set<AdvertisingUserResponseDTO> advertisings) {

    public JobResponseDTO(Job job) {
        this(
                job.getId(),
                job.getName(),
                job.getDescription(),
                new HashSet<>(),
                new HashSet<>()
        );
    }

    public JobResponseDTO(Job job, Set<Category> categories, Set<Advertising> advertisings) {
        this(job);
        categories.forEach(cat -> this.categories.add(new CategoryResponseDTO(cat)));
        advertisings.forEach(ad -> this.advertisings.add(new AdvertisingUserResponseDTO(ad)));
    }
}
