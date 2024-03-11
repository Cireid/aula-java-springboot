package com.curso.java.nazareno.java21.data;

import java.util.Collections;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.curso.java.nazareno.java21.model.Curso;
import com.curso.java.nazareno.java21.repository.CursoRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DataInitializer {

    @Bean
    public CommandLineRunner loadDatabase(CursoRepository repository) {
        log.info("Loading data...");
        if (repository.count() > 0) {
            return (args) -> {
                log.info("Database is not empty");
            };
        }
        return (args) -> {
            repository.save(new Curso(1l, "Curso 1", 6, Collections.emptyList()));
            repository.save(new Curso(2l, "Curso 2", 4, Collections.emptyList()));
            repository.save(new Curso(3l, "Curso 3", 20, Collections.emptyList()));
        };
    }
}
