package com.example.SkillHub.repositories;

import com.example.SkillHub.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
