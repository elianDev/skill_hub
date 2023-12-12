package com.example.SkillHub.repositories;

import com.example.SkillHub.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
