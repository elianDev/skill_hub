package com.example.SkillHub.services;

import com.example.SkillHub.dto.job.JobResponseDTO;
import com.example.SkillHub.entities.Job;
import com.example.SkillHub.repositories.JobRepository;
import com.example.SkillHub.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JobService {

    @Autowired
    private JobRepository repository;

    @Transactional(readOnly = true)
    public Page<JobResponseDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(x -> new JobResponseDTO(x, x.getCategories(), x.getAdvertisings()));
    }

    @Transactional(readOnly = true)
    public JobResponseDTO findById(Long id) {
        Job entity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Resource not found")
        );
        return new JobResponseDTO(entity, entity.getCategories(), entity.getAdvertisings());
    }
}
