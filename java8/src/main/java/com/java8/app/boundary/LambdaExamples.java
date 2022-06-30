package com.java8.app.boundary;

import com.java8.app.util.CompareStringByLength;
import com.java8.app.util.StringConsumer;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class LambdaExamples {

    public void sortOldWays(List<String> list){
        // This way is the old way, we create a class to compare
        Comparator<String> comparador = new CompareStringByLength();
        list.sort(comparador);
    }

    public void sortWithLambda(List<String> list){
        list.sort(Comparator.comparingInt(String::length));
    }

    public void sortWithLambdaByAlfabethicOrder(List<String> list){
        list.sort(Comparator.naturalOrder());
    }

    public void sortWithLabmdaExplained(List<String> list){
        // The lambda expression is actually a Function implementation where the first
        // argument is the type provide and the second one the type of result.
        // It can be also written as Object::Method for example, String::length
        Function<String, Integer> funcao = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };
        Comparator<String> comparator = Comparator.comparing(funcao);
        list.sort(comparator);
    }

    public void printListOldWay(List<String> list){
        // This way we create a Consumer class
        Consumer<String> consumidor = new StringConsumer();
        list.forEach(consumidor);
    }

    public void printListWithLambda(List<String> list){
        // As described in sortWithLabmdaExplained we can also call a lambda here using System.out
        // Quick reminder, the Consumer object does not have a return, therefore its always void
        // this is why we can use variables that were declared outside the for each using stream.
        list.forEach(System.out::println);
    }
}

