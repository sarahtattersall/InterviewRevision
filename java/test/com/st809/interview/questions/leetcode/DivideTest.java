package com.st809.interview.questions.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DivideTest {

    @Test
    public void positiveDividend1() {
        assertEquals(10, Divide.divide(10, 1));
    }


    @Test
    public void positiveDividend2() {
        assertEquals(5, Divide.divide(10, 2));
    }


    @Test
    public void positiveDividend3() {
        assertEquals(3, Divide.divide(10, 3));
    }

    @Test
    public void negativeValue() {
        assertEquals(-3, Divide.divide(-10, 3));
    }

    @Test
    public void negativeDividend1() {
        assertEquals(-10, Divide.divide(10, -1));
    }
    @Test
    public void negativeDividend2() {
        assertEquals(10, Divide.divide(-10, -1));
    }
}
