package com.st809.interview.questions.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IntegerPalindromeTest {
    @Test
    public void negative() {
        assertFalse(IntegerPalindrome.isPalindrome(-1));
    }

    @Test
    public void zero() {
        assertTrue(IntegerPalindrome.isPalindrome(0));
    }

    @Test
    public void singleDigitPalindrome() {
        assertTrue(IntegerPalindrome.isPalindrome(1));
    }

    @Test
    public void doubleDigitPalindrome() {
        assertTrue(IntegerPalindrome.isPalindrome(22));

    }
    @Test
    public void doubleDigitNotPalindrome() {
        assertFalse(IntegerPalindrome.isPalindrome(29));

    }

    @Test
    public void tripleDigitPalindrome() {
        assertTrue(IntegerPalindrome.isPalindrome(212));
    }


    @Test
    public void tripleDigitNotPalindrome() {
        assertFalse(IntegerPalindrome.isPalindrome(912));
    }

    @Test
    public void largeDigitPalindrom() {
        assertTrue(IntegerPalindrome.isPalindrome(123454321));
    }

    @Test
    public void largeDigitNotPalindrom() {
        assertFalse(IntegerPalindrome.isPalindrome(123954321));
    }
}
