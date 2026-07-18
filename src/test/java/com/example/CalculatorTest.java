package com.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


@DisplayName("com.example.Calculator")
class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        // Runs before every test - each test gets a fresh instance
        calculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
        // Runs after every test - useful for cleanup (closing files, connections, etc.)
        calculator = null;
    }

    @Test
    @DisplayName("adds two positive numbers")
    void testAdd() {
        assertEquals(5, calculator.add(2, 3));
        assertEquals(7, calculator.add(5,2));
    }

    @Test
    @DisplayName("handles negative numbers")
    void testAddNegatives() {
        // assertAll runs every assertion and reports all failures together
        assertAll(
                () -> assertEquals(-5, calculator.add(-2, -3)),
                () -> assertEquals(1, calculator.add(-2, 3)),
                () -> assertEquals(0, calculator.add(2, -2))
        );
    }

    @Test
    @DisplayName("subtracts correctly")
    void testSubtract() {
        assertEquals(4, calculator.subtract(7, 3));
    }

    @Test
    @DisplayName("multiplies correctly")
    void testMultiply() {
        assertEquals(21, calculator.multiply(7, 3));
        System.out.println(Thread.currentThread().getName() + " -> testAdd");
    }

    @Nested
    @DisplayName("division")
    class Division {

        @Test
        @DisplayName("divides evenly")
        void testDivide() {
            assertEquals(2.5, calculator.divide(5, 2), 0.0001);
            System.out.println(Thread.currentThread().getName() + " -> testAdd");
        }

        @Test
        @DisplayName("throws on divide by zero")
        void testDivideByZero() {
            // assertThrows verifies the exception type AND lets you inspect it
            ArithmeticException ex = assertThrows(
                    ArithmeticException.class,
                    () -> calculator.divide(10, 0)
            );
            assertEquals("Cannot divide by zero", ex.getMessage());
        }
    }

    @Test
    @DisplayName("detects even and odd numbers")
    void testIsEven() {
        assertTrue(calculator.isEven(4));
        assertFalse(calculator.isEven(7));
        System.out.println(Thread.currentThread().getName() + " -> testAdd");
        System.out.println("Hey Manav");
        //
    }
}
