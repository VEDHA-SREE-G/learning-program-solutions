// File: src/test/java/com/example/CalculatorTest.java
package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testAdd() {
        CalculatorProgram calc = new CalculatorProgram();
        int result = calc.add(3, 2);
        assertEquals(5, result);
    }
}
