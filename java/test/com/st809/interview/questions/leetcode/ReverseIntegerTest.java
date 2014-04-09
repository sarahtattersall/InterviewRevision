package com.st809.interview.questions.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseIntegerTest {

    @Test
    public void reverseSingle() {
        assertEquals(1, ReverseInteger.reverse(1));
    }

    @Test
    public void reverseDouble() {
        assertEquals(12, ReverseInteger.reverse(21));
    }

    @Test
    public void reverseTriple() {
        assertEquals(321, ReverseInteger.reverse(123));
    }

    @Test
    public void reverseLarge() {
        assertEquals(87654321, ReverseInteger.reverse(12345678)) ;
    }

    @Test
    public void reverseSingleNegative() {
        assertEquals(-5, ReverseInteger.reverse(-5));
    }

    @Test
    public void reverseDoubleNegative() {
        assertEquals(-95, ReverseInteger.reverse(-59));
    }

    @Test
    public void reverseLargeNegative() {
        assertEquals(-8765432, ReverseInteger.reverse(-2345678));
    }

    @Test
    public void overflow() {
        assertEquals(Integer.MAX_VALUE, ReverseInteger.reverse(1000000003));
    }

    @Test
    public void overflowNegative() {
        assertEquals(Integer.MIN_VALUE, ReverseInteger.reverse(-1000000003));
    }
}
