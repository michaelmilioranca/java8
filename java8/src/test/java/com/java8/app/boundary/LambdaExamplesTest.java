package com.java8.app.boundary;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LambdaExamplesTest {

    @Test
    void shouldOrderByAlfabethic(){
        List<String> given = new ArrayList<>();
        given.add("banana");
        given.add("apple");
        given.add("pearl");
        given.add("cucumber");
        List<String> expected = List.of("apple", "banana", "cucumber", "pearl");
        LambdaExamples lambdaExamples = new LambdaExamples();
        lambdaExamples.sortWithLambdaByAlfabethicOrder(given);
        assertEquals(expected, given);
    }
}