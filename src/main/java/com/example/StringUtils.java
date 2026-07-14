package com.example;

/**
 * Small string helper class, used to demonstrate parameterized tests.
 */
public class StringUtils {

    public static String reverse(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        return new StringBuilder(input).reverse().toString();
    }

    public static boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }
        String cleaned = input.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        return cleaned.equals(new StringBuilder(cleaned).reverse().toString());
    }

    public static boolean isBlank(String input) {
        return input == null || input.trim().isEmpty();
    }
}