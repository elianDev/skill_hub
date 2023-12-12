package com.example.SkillHub.repositories;

import com.example.SkillHub.entities.ContracterAd;
import com.example.SkillHub.entities.pk.ContracterAdPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContracterAdRepository extends JpaRepository<ContracterAd, ContracterAdPK> {
}
