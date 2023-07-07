package com.alunoonline.v1.secretaria.controllers;

import com.alunoonline.v1.secretaria.models.Professor;
import com.alunoonline.v1.secretaria.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    ProfessorService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Professor> create(@RequestBody Professor professor) {
        Professor professorCreated = service.create(professor);
        return ResponseEntity.status(201).body(professorCreated);
    }
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Professor> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Professor> findById(@PathVariable Long id){
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professor> updateProf(@PathVariable Long id, @RequestBody @Validated Professor professorAtt) {
        return new ResponseEntity<>(service.updateProf(id, professorAtt),HttpStatus.CREATED);
    }
}
