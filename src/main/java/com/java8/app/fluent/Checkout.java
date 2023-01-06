package com.java8.app.fluent;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public class Checkout {

    private final Sandwich sandwich;

    private final int quantity;

    private final Drink drink;

    private final int drinkQuantity;

    private final BigDecimal total;
}
