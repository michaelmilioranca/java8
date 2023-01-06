package com.java8.app.fluent;

import java.math.BigDecimal;

public class Drink {

    private final DrinkType type;

    private final BigDecimal price;

    Drink(DrinkType type, BigDecimal price) {
        this.type = type;
        this.price = price;
    }

    public DrinkType getType() {
        return type;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
