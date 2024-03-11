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

import com.curso.java.nazareno.java21.model.Estudante;
import com.curso.java.nazareno.java21.repository.EstudanteRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/estudante")
public class EstudanteController {
    private final EstudanteRepository estudanteRepository;

    @Autowired
    public EstudanteController(EstudanteRepository estudanteRepository) {
        this.estudanteRepository = estudanteRepository;
    }

    @GetMapping("/")
    public ResponseEntity<List<Estudante>> getAllCursos() {
        log.info("Initialing get all curso methods");
        return ResponseEntity.ok(estudanteRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudante> getCursoById(@PathVariable Long id) {
        log.info("Initialing find curso by id method");
        Optional<Estudante> estudanteptional = estudanteRepository.findById(id);
        if (estudanteptional.isPresent()) {
            return ResponseEntity.ok(estudanteptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Estudante> createCurso(@RequestBody Estudante estudante) {
        log.info("Initialing create curso method");
        return ResponseEntity.ok(estudanteRepository.save(estudante));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudante> updateCurso(@PathVariable Long id, @RequestBody Estudante estudante) {
        log.info("Initialing update curso method");
        Estudante estudanteFound = estudanteRepository.findById(id).orElse(null);
        if (estudanteFound != null) {
            estudanteFound.setNome(estudante.getNome());
            estudanteFound.setDataMatricula(estudante.getDataMatricula());
            return ResponseEntity.ok(estudanteRepository.save(estudanteFound));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurso(@PathVariable Long id) {
        log.info("Initialing delete curso method");
        estudanteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
