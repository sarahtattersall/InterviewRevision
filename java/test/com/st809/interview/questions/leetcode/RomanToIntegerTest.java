package com.st809.interview.questions.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RomanToIntegerTest {

    @Test
    public void one() {
        assertEquals(1, RomanToInteger.romanToInt("I"));
    }

    @Test
    public void two() {
        assertEquals(2, RomanToInteger.romanToInt("II"));
    }

    @Test
    public void four() {
        assertEquals(4, RomanToInteger.romanToInt("IV"));
    }


    @Test
    public void five() {
        assertEquals(5, RomanToInteger.romanToInt("V"));
    }

    @Test
    public void seven() {
        assertEquals(7, RomanToInteger.romanToInt("VII"));
    }

    @Test
    public void nine() {
        assertEquals(9, RomanToInteger.romanToInt("VIV"));
    }


    @Test
    public void nineTwo() {
        assertEquals(9, RomanToInteger.romanToInt("IX"));
    }

    @Test
    public void ten() {
        assertEquals(10, RomanToInteger.romanToInt("X"));
    }

    @Test
    public void eleven() {
        assertEquals(11, RomanToInteger.romanToInt("XI"));
    }

    @Test
    public void fourty() {
        assertEquals(40, RomanToInteger.romanToInt("XL"));
    }

    @Test
    public void fifty() {
        assertEquals(50, RomanToInteger.romanToInt("L"));
    }

    @Test
    public void ninety() {
        assertEquals(90, RomanToInteger.romanToInt("XC"));
    }


    @Test
    public void hundred() {
        assertEquals(100, RomanToInteger.romanToInt("C"));
    }


    @Test
    public void hundredNinety() {
        assertEquals(190, RomanToInteger.romanToInt("CXC"));
    }


    @Test
    public void twoHundred() {
        assertEquals(200, RomanToInteger.romanToInt("CC"));
    }

    @Test
    public void fourHundred() {
        assertEquals(400, RomanToInteger.romanToInt("CD"));
    }

    @Test
    public void fiveHundred() {
        assertEquals(500, RomanToInteger.romanToInt("D"));
    }


    @Test
    public void fiveHundredThirty() {
        assertEquals(530, RomanToInteger.romanToInt("DXXX"));
    }

    @Test
    public void nineHundred() {
        assertEquals(900, RomanToInteger.romanToInt("CM"));
    }

    @Test
    public void thousand() {
        assertEquals(1000, RomanToInteger.romanToInt("M"));
    }

    @Test
    public void thousandNineHundredFour() {
        assertEquals(1904, RomanToInteger.romanToInt("MCMIV"));
    }

    @Test
    public void twoThousand() {
        assertEquals(2000, RomanToInteger.romanToInt("MM"));
    }






}
