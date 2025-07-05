package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;

    // 🔧 Setup method - runs before each test
    @Before
    public void setUp() {
        System.out.println("Setting up Calculator...");
        calculator = new Calculator();
    }

    // 🧹 Teardown method - runs after each test
    @After
    public void tearDown() {
        System.out.println("Cleaning up after test...");
        calculator = null;
    }

    @Test
    public void testAdd() {
        // Arrange
        int a = 5;
        int b = 3;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(8, result);
    }

    @Test
    public void testSubtract() {
        // Arrange
        int a = 10;
        int b = 4;

        // Act
        int result = calculator.subtract(a, b);

        // Assert
        assertEquals(6, result);
    }
}
