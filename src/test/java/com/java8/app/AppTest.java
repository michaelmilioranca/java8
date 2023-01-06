package com.java8.app;

import com.java8.app.fluent.Bread;
import com.java8.app.fluent.Checkout;
import com.java8.app.fluent.Order;
import com.java8.app.fluent.Size;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testFluentBuilder(){
        Checkout checkout = Order.bread(Bread.SOURDOUGH).size(Size.MEDIUM).meat().quantity(1).cocktail();
    }
}
