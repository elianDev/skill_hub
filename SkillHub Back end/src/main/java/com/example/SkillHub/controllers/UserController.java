package com.example.SkillHub.controllers;

import com.example.SkillHub.dto.user.UserRequestDTO;
import com.example.SkillHub.dto.user.UserResponseDTO;
import com.example.SkillHub.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<Page<UserResponseDTO>> findAll(Pageable pageable) {
        Page<UserResponseDTO> list = service.findAll(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable Long id) {
        UserResponseDTO result = service.findById(id);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> insert(@RequestBody UserRequestDTO dto) {
        UserResponseDTO response = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
                .buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserResponseDTO> update(@PathVariable Long id, @RequestBody UserRequestDTO dto) {
        UserResponseDTO response = service.update(id, dto);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
