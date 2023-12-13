package com.example.SkillHub.services;

import com.example.SkillHub.dto.advertising.AdvertisingRequestDTO;
import com.example.SkillHub.dto.advertising.AdvertisingResponseDTO;
import com.example.SkillHub.entities.Advertising;
import com.example.SkillHub.repositories.AdvertisingRepository;
import com.example.SkillHub.repositories.JobRepository;
import com.example.SkillHub.repositories.UserRepository;
import com.example.SkillHub.services.exceptions.DatabaseException;
import com.example.SkillHub.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdvertisingService {

    @Autowired
    private AdvertisingRepository repository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public Page<AdvertisingResponseDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(x -> new AdvertisingResponseDTO(x, x.getReviews()));
    }

    @Transactional(readOnly = true)
    public AdvertisingResponseDTO findById(Long id) {
        Advertising entity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Resource not found")
        );
        return new AdvertisingResponseDTO(entity, entity.getReviews());
    }

    @Transactional
    public AdvertisingResponseDTO insert(AdvertisingRequestDTO dto) {
        Advertising entity = new Advertising();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new AdvertisingResponseDTO(entity);
    }

    @Transactional
    public AdvertisingResponseDTO update(Long id, AdvertisingRequestDTO dto) {
        try {
            Advertising entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new AdvertisingResponseDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Resource not found");
        }

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Resource not found");
        }
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Referential integrity failure");
        }
    }

    private void copyDtoToEntity(AdvertisingRequestDTO dto, Advertising entity) {
        entity.setTitle(dto.title());
        entity.setDescription(dto.description());
        entity.setPrice(dto.price());
        entity.setImgUrl(dto.imgUrl());

        entity.setJob(jobRepository.getReferenceById(dto.jobId()));
        entity.setSeller(userRepository.getReferenceById(dto.sellerId()));
    }
}
