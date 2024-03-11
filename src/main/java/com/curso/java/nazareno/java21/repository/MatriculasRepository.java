package com.curso.java.nazareno.java21.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.java.nazareno.java21.model.Matriculas;

@Repository
public interface MatriculasRepository extends JpaRepository<Matriculas, Long> {}
