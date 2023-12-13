package com.example.SkillHub.services;

import com.example.SkillHub.dto.review.ReviewRequestDTO;
import com.example.SkillHub.dto.review.ReviewResponseDTO;
import com.example.SkillHub.entities.Review;
import com.example.SkillHub.repositories.ReviewRepository;
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
public class ReviewService {

    @Autowired
    private ReviewRepository repository;

    @Transactional(readOnly = true)
    public Page<ReviewResponseDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(ReviewResponseDTO::new);
    }

    @Transactional(readOnly = true)
    public ReviewResponseDTO findById(Long id) {
        Review entity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Resource not found")
        );
        return new ReviewResponseDTO(entity);
    }

    @Transactional
    public ReviewResponseDTO insert(ReviewRequestDTO dto) {
        Review entity = new Review();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new ReviewResponseDTO(entity);
    }

    @Transactional
    public ReviewResponseDTO update(Long id, ReviewRequestDTO dto) {
        try {
            Review entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new ReviewResponseDTO(entity);
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

    private void copyDtoToEntity(ReviewRequestDTO dto, Review entity) {
        entity.setText(dto.text());
        entity.setStarRate(dto.starRate());
    }
}
