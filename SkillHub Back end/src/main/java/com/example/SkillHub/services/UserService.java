package com.example.SkillHub.services;

import com.example.SkillHub.dto.user.UserResponseDTO;
import com.example.SkillHub.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Transactional(readOnly = true)
    public Page<UserResponseDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(x -> new UserResponseDTO(x, x.getAdvertisings()));
    }
}
