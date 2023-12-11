package de.bergmanninfotech.joggingtrackerapi.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    public void testDistanceCalculation() {
        // values are taken from google maps
        double expected = 0.6f;
        double calculated = Calculator.calculateDistanceInKm(40.177433, 44.507597, 40.172965, 44.511341);
        System.out.println(Math.round(calculated * 10) );
        assertEquals(expected, (float)Math.round(calculated * 10) / 10);
        System.out.println();
    }
}
