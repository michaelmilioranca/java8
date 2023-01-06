package com.java8.app.boundary;

import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LambdaExamplesTest {

    @Test
    @Tag("slowTest")
    public void shouldOrderByAlfabethic(){
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
    
    @Test
    @Disabled
    void shouldReturnRandomValue(){
        String smh = candyLottery();
        assertEquals("fail", smh);
    }

    private String candyLottery(){
        List<String> names = new ArrayList<>();
        names.add("Joao");
        names.add("Afonso");
        names.add("Manuel");
        names.add("Michael");
        names.add("Raul");

        Random r = new Random();

        int random = r.nextInt(5);

        return names.get(random);
    }
}