package com.example.SkillHub.controllers;

import com.example.SkillHub.dto.advertising.AdvertisingRequestDTO;
import com.example.SkillHub.dto.advertising.AdvertisingResponseDTO;
import com.example.SkillHub.services.AdvertisingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/advertisings")
public class AdvertisingController {

    @Autowired
    private AdvertisingService service;

    @GetMapping
    public ResponseEntity<Page<AdvertisingResponseDTO>> findAll(Pageable pageable) {
        Page<AdvertisingResponseDTO> list = service.findAll(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AdvertisingResponseDTO> findById(@PathVariable Long id) {
        AdvertisingResponseDTO result = service.findById(id);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping
    public ResponseEntity<AdvertisingResponseDTO> insert(@Valid @RequestBody AdvertisingRequestDTO dto) {
        AdvertisingResponseDTO response = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
                .buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AdvertisingResponseDTO> update(@PathVariable Long id, @Valid @RequestBody AdvertisingRequestDTO dto) {
        AdvertisingResponseDTO response = service.update(id, dto);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
