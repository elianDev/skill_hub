package com.example.SkillHub.services;

import com.example.SkillHub.dto.user.UserRequestDTO;
import com.example.SkillHub.dto.user.UserResponseDTO;
import com.example.SkillHub.entities.User;
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
public class UserService {

    @Autowired
    private UserRepository repository;

    @Transactional(readOnly = true)
    public Page<UserResponseDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(x -> new UserResponseDTO(x, x.getAdvertisings()));
    }

    @Transactional(readOnly = true)
    public UserResponseDTO findById(Long id) {
        User entity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Resource not found")
        );
        return new UserResponseDTO(entity, entity.getAdvertisings());
    }

    @Transactional
    public UserResponseDTO insert(UserRequestDTO dto) {
        User entity = new User();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new UserResponseDTO(entity);
    }

    @Transactional
    public UserResponseDTO update(Long id, UserRequestDTO dto) {
        try {
            User entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new UserResponseDTO(entity);
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
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Referential integrity failure");
        }
    }

    private void copyDtoToEntity(UserRequestDTO dto, User entity) {
        entity.setName(dto.name());
        entity.setEmail(dto.email());
        entity.setPassword(dto.password());
        entity.setBirthDate(dto.birthDate());
        entity.setPhone(dto.phone());
    }
}
