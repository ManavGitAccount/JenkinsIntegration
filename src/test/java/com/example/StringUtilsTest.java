package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


@DisplayName("com.example.StringUtils")
class StringUtilsTest {

    // --- Parameterized test with multiple input/expected pairs ---
    @ParameterizedTest(name = "reverse(\"{0}\") = \"{1}\"")
    @CsvSource({
            "hello,  olleh",
            "abc,    cba",
            "a,      a",
            "'',     ''"
    })
    void testReverse(String input, String expected) {
        assertEquals(expected.trim(), StringUtils.reverse(input.trim()));
    }

    @Test
    @DisplayName("reverse throws on null input")
    void testReverseNull() {
        assertThrows(IllegalArgumentException.class, () -> StringUtils.reverse(null));
    }

    // --- Parameterized test with a list of values that should all pass ---
    @ParameterizedTest(name = "\"{0}\" is a palindrome")
    @ValueSource(strings = {
            "racecar",
            "madam",
            "A man, a plan, a canal: Panama",
            "12321"
    })
    void testIsPalindromeTrue(String input) {
        assertTrue(StringUtils.isPalindrome(input));
    }

    @ParameterizedTest(name = "\"{0}\" is NOT a palindrome")
    @ValueSource(strings = {"hello", "java", "junit"})
    void testIsPalindromeFalse(String input) {
        assertFalse(StringUtils.isPalindrome(input));
    }

    // --- NullAndEmptySource injects null and "" as test cases ---
    @ParameterizedTest(name = "isBlank handles null/empty/whitespace")
    @NullAndEmptySource
    @ValueSource(strings = {"   ", "\t", "\n"})
    void testIsBlank(String input) {
        assertTrue(StringUtils.isBlank(input));
    }

    @Test
    @DisplayName("isBlank returns false for real content")
    void testIsNotBlank() {
        assertFalse(StringUtils.isBlank("hello"));
    }
}