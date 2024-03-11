package com.curso.java.nazareno.java21.repository;

import org.springframework.stereotype.Repository;

import com.curso.java.nazareno.java21.model.Curso;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {}
