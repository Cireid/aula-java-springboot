package com.curso.java.nazareno.java21.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.java.nazareno.java21.model.Curso;
import com.curso.java.nazareno.java21.repository.CursoRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/curso")
public class CursoController {
    private final CursoRepository cursoRepository;

    @Autowired
    public CursoController(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @GetMapping("/")
    public ResponseEntity<List<Curso>> getAllCursos() {
        log.info("Initialing get all curso methods");
        return ResponseEntity.ok(cursoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> getCursoById(@PathVariable Long id) {
        log.info("Initialing find curso by id method");
        Optional<Curso> cursoOptional = cursoRepository.findById(id);
        if (cursoOptional.isPresent()) {
            return ResponseEntity.ok(cursoOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Curso> createCurso(@RequestBody Curso curso) {
        log.info("Initialing create curso method");
        return ResponseEntity.ok(cursoRepository.save(curso));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> updateCurso(@PathVariable Long id, @RequestBody Curso curso) {
        log.info("Initialing update curso method");
        Curso cursoFound = cursoRepository.findById(id).orElse(null);
        if (cursoFound != null) {
            cursoFound.setTitulo(curso.getTitulo());
            cursoFound.setCreditos(curso.getCreditos());
            return ResponseEntity.ok(cursoRepository.save(cursoFound));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurso(@PathVariable Long id) {
        log.info("Initialing delete curso method");
        cursoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
