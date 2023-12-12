package com.example.SkillHub.repositories;

import com.example.SkillHub.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
