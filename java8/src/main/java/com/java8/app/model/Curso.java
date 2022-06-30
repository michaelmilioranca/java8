package com.java8.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Curso {
    private final String nomeCurso;
    private final int numeroDeAlunos;
}
