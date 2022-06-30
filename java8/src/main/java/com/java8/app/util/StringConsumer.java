package com.java8.app.util;

import java.util.function.Consumer;

public class StringConsumer implements Consumer<String> {
    @Override
    public void accept(String s) {
        System.out.println(s);
    }
}

