package com.java8.app.fluent;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;

enum PricingTables {

    INSTANCE;

    private final Map<Size, BigDecimal> sizePrice;

    private final Map<SandwichStyle, BigDecimal> stylePrice;

    private final Map<DrinkType, BigDecimal> drinkPrice;

    private final Map<Bread, BigDecimal> breadPrice;

    PricingTables() {
        
        this.sizePrice = new EnumMap<>(Size.class);
        this.sizePrice.put(Size.SMALL, BigDecimal.valueOf(1));
        this.sizePrice.put(Size.MEDIUM, BigDecimal.valueOf(5));
        this.sizePrice.put(Size.LARGE, BigDecimal.valueOf(10));

        this.stylePrice = new EnumMap<>(SandwichStyle.class);
        this.stylePrice.put(SandwichStyle.MEAT, BigDecimal.valueOf(10));
        this.stylePrice.put(SandwichStyle.VEGAN, BigDecimal.valueOf(12));

        this.drinkPrice = new EnumMap<>(DrinkType.class);
        this.drinkPrice.put(DrinkType.SOFT_DRINK, BigDecimal.valueOf(1));
        this.drinkPrice.put(DrinkType.COCKTAIL, BigDecimal.valueOf(6));

        this.breadPrice = new EnumMap<>(Bread.class);
        this.breadPrice.put(Bread.BAGUETTE, BigDecimal.valueOf(1));
        this.breadPrice.put(Bread.SOURDOUGH, BigDecimal.valueOf(2));
        this.breadPrice.put(Bread.BRIOCHE, BigDecimal.valueOf(3));
    }

    BigDecimal getPrice(DrinkType type) {
        return Optional.ofNullable(this.drinkPrice.get(type))
                .orElseThrow(() -> new IllegalArgumentException("There is not price to the drink " + type));
    }

    BigDecimal getPrice(Bread bread) {
        return Optional.ofNullable(this.breadPrice.get(bread))
                .orElseThrow(() -> new IllegalArgumentException("There is not price to the bread " + bread));
    }


    BigDecimal getPrice(SandwichStyle style) {
        return Optional.ofNullable(this.stylePrice.get(style))
                .orElseThrow(() -> new IllegalArgumentException("There is not price to the sandwich style " + style));
    }

    BigDecimal getPrice(Size size) {
        return Optional.ofNullable(this.sizePrice.get(size))
                .orElseThrow(() -> new IllegalArgumentException("There is not price to the size " + size));
    }
}