package com.example.SkillHub.services;

import com.example.SkillHub.dto.category.CategoryResponseDTO;
import com.example.SkillHub.entities.Category;
import com.example.SkillHub.repositories.CategoryRepository;
import com.example.SkillHub.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public Page<CategoryResponseDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(CategoryResponseDTO::new);
    }

    @Transactional(readOnly = true)
    public CategoryResponseDTO findById(Long id) {
        Category entity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Resource not found")
        );
        return new CategoryResponseDTO(entity);
    }
}
