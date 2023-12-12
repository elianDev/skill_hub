package com.example.SkillHub.repositories;

import com.example.SkillHub.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
