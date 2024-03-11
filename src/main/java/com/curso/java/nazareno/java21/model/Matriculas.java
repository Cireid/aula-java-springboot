package com.curso.java.nazareno.java21.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Matriculas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Long idCurso;

    Long idEstudante;
    
}
