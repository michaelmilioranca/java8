package com.java8.app.fluent;

import java.math.BigDecimal;
import java.util.Objects;

class OrderFluent implements Order.SizeOrder, Order.StyleOrder, Order.StyleQuantityOrder, Order.DrinksOrder {

    private final PricingTables pricingTables = PricingTables.INSTANCE;

    private final Bread bread;

    private Size size;

    private Sandwich sandwich;

    private int quantity;

    private Drink drink;

    private int drinkQuantity;

    OrderFluent(Bread bread) {
        this.bread = bread;
    }

    @Override
    public Order.StyleOrder size(Size size) {
        Objects.requireNonNull(size, "Size is required");
        this.size = size;
        return this;
    }

    @Override
    public Order.StyleQuantityOrder vegan() {
        createSandwich(SandwichStyle.VEGAN);
        return this;
    }

    @Override
    public Order.StyleQuantityOrder meat() {
        createSandwich(SandwichStyle.MEAT);
        return this;
    }

    @Override
    public Order.DrinksOrder quantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("You must request at least one sandwich");
        }
        this.quantity = quantity;
        return this;
    }

    @Override
    public Checkout softDrink(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("You must request at least one sandwich");
        }
        this.drinkQuantity = quantity;
        this.drink = new Drink(DrinkType.SOFT_DRINK, pricingTables.getPrice(DrinkType.SOFT_DRINK));
        return checkout();
    }

    @Override
    public Checkout cocktail(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("You must request at least one sandwich");
        }
        this.drinkQuantity = quantity;
        this.drink = new Drink(DrinkType.COCKTAIL, pricingTables.getPrice(DrinkType.COCKTAIL));
        return checkout();
    }

    @Override
    public Checkout softDrink() {
        return softDrink(1);
    }

    @Override
    public Checkout cocktail() {
        return cocktail(1);
    }

    @Override
    public Checkout noBeveragesThanks() {
        return checkout();
    }

    private Checkout checkout() {
        BigDecimal total = sandwich.getPrice().multiply(BigDecimal.valueOf(quantity));
        if (drink != null) {
            BigDecimal drinkTotal = drink.getPrice().multiply(BigDecimal.valueOf(drinkQuantity));
            total = total.add(drinkTotal);
        }
        return new Checkout(sandwich, quantity, drink, drinkQuantity, total);
    }

    private void createSandwich(SandwichStyle style) {
        BigDecimal breadPrice = pricingTables.getPrice(this.bread);
        BigDecimal sizePrice = pricingTables.getPrice(this.size);
        BigDecimal stylePrice = pricingTables.getPrice(SandwichStyle.VEGAN);
        BigDecimal total = breadPrice.add(sizePrice).add(stylePrice);
        this.sandwich = new Sandwich(style, this.bread, this.size, total);
    }
}
