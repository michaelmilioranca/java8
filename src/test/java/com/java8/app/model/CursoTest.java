package com.java8.app.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class CursoTest {

    @Test
    void imprimirCursos() {
        List<Curso> cursos = getMockCursos();

        cursos.sort(Comparator.comparing(Curso::getNumeroDeAlunos));

        cursos.forEach(curso -> System.out.println(curso.getNomeCurso()));
    }

    @Test
    void filtrarCursos() {
        List<Curso> cursos = getMockCursos();

        // obs: Stream não altera os objectos que o invocam.
        cursos.stream()
                .filter(curso -> curso.getNumeroDeAlunos() >= 49)
                .forEach(curso -> System.out.println(curso.getNomeCurso()));
    }

    @Test
    void filtrarCursoComMap() {
        List<Curso> cursos = getMockCursos();

        cursos.stream()
                .map(Curso::getNumeroDeAlunos)
                // O map retorna uma nova stream com o resultado que você mapeia
                .filter(numeroDeAlunos -> numeroDeAlunos >= 49)
                .forEach(System.out::println);
    }

    @Test
    void somarAlunosComFiltro() {
        List<Curso> cursos = getMockCursos();
        // Os Stream tem tipos especificos, como IntStream que possui metodos proprios que podem ser uteis
        int result = cursos.stream()
                .filter(curso -> curso.getNumeroDeAlunos() >= 49)
                // O map retorna uma nova stream com o resultado que você mapeia
                .mapToInt(Curso::getNumeroDeAlunos)
                .sum();
        System.out.println(result);
    }

    @Test
    void imprimirApenasSeExistirDadoFiltro() {
        List<Curso> cursos = getMockCursos();
        // Apenas vai imprimir se existir, pois o "ifPresent" retorna um Optional
        // caso não exista, não ira fazer nada
        cursos.stream()
                .filter(curso -> curso.getNumeroDeAlunos() > 55)
                .findAny()
                .ifPresent(curso -> System.out.println(curso.getNomeCurso()));
    }

    @Test
    void transformandoStreamEmMap() {
        List<Curso> cursos = getMockCursos();
        // O metodo collectors também pode retornar um map, além de passar assim, pdoemos usar um bloco de código {} para retornar um valor
        // Obs: também existe o parallelStream, porém é bom tomar cuidado se compensa a utilização do mesmo, pois em casos simples como soma, média etc
        // acaba sendo mais demorado pois existe um overhead do paralelismo
        cursos.stream()
                .filter(curso -> curso.getNumeroDeAlunos() > 0)
                .collect(Collectors.toMap(Curso::getNomeCurso, Curso::getNumeroDeAlunos))
                .forEach((nome, aluno) -> System.out.println(nome + " tem " + aluno + " alunos"));

    }

    @Test
    void obterMediaDeAlunosComStream() {
        List<Curso> cursos = getMockCursos();
        double average =
                cursos.stream()
                        .mapToLong(Curso::getNumeroDeAlunos)
                        .average()
                        .orElse(0);

        System.out.println("Média de alunos: " + average);
    }

    private List<Curso> getMockCursos() {
        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso("Python", 45));
        cursos.add(new Curso("C", 32));
        cursos.add(new Curso("Java 8", 98));
        cursos.add(new Curso("JavaScript", 56));
        return cursos;
    }

}