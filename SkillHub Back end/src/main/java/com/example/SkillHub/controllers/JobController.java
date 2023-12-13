package com.example.SkillHub.controllers;

import com.example.SkillHub.dto.job.JobResponseDTO;
import com.example.SkillHub.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/jobs")
public class JobController {

    @Autowired
    private JobService service;

    @GetMapping
    public ResponseEntity<Page<JobResponseDTO>> findAll(Pageable pageable) {
        Page<JobResponseDTO> list = service.findAll(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<JobResponseDTO> findById(@PathVariable Long id) {
        JobResponseDTO result = service.findById(id);
        return ResponseEntity.ok().body(result);
    }

}
