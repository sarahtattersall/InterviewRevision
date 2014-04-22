package com.st809.interview.questions.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidPalindromeTest {

    @Test
    public void palindrome() {
        assertTrue(ValidPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
    }
    @Test
    public void notPalindrome() {
        assertFalse(ValidPalindrome.isPalindrome("race a car"));
    }
    @Test
    public void numericNot() {
        assertFalse(ValidPalindrome.isPalindrome("1a2"));
    }
}
