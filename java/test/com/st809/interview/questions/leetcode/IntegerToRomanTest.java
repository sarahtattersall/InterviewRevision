package com.st809.interview.questions.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntegerToRomanTest {

    @Test
    public void one() {
        assertEquals("I", IntegerToRoman.intToRoman(1));
    }

    @Test
    public void two() {
        assertEquals("II", IntegerToRoman.intToRoman(2));
    }

    @Test
    public void four() {
        assertEquals("IV", IntegerToRoman.intToRoman(4));
    }


    @Test
    public void five() {
        assertEquals("V", IntegerToRoman.intToRoman(5));
    }

    @Test
    public void seven() {
        assertEquals("VII", IntegerToRoman.intToRoman(7));
    }

    @Test
    public void nine() {
        assertEquals("IX", IntegerToRoman.intToRoman(9));
    }

    @Test
    public void ten() {
        assertEquals("X", IntegerToRoman.intToRoman(10));
    }

    @Test
    public void eleven() {
        assertEquals("XI", IntegerToRoman.intToRoman(11));
    }

    @Test
    public void fourty() {
        assertEquals("XL", IntegerToRoman.intToRoman(40));
    }

    @Test
    public void fifty() {
        assertEquals("L", IntegerToRoman.intToRoman(50));
    }

    @Test
    public void ninety() {
        assertEquals("XC", IntegerToRoman.intToRoman(90));
    }


    @Test
    public void hundred() {
        assertEquals("C", IntegerToRoman.intToRoman(100));
    }


    @Test
    public void hundredNinety() {
        assertEquals("CXC", IntegerToRoman.intToRoman(190));
    }


    @Test
    public void twoHundred() {
        assertEquals("CC", IntegerToRoman.intToRoman(200));
    }

    @Test
    public void fourHundred() {
        assertEquals("CD", IntegerToRoman.intToRoman(400));
    }

    @Test
    public void fiveHundred() {
        assertEquals("D", IntegerToRoman.intToRoman(500));
    }


    @Test
    public void fiveHundredThirty() {
        assertEquals("DXXX", IntegerToRoman.intToRoman(530));
    }

    @Test
    public void nineHundred() {
        assertEquals("CM", IntegerToRoman.intToRoman(900));
    }

    @Test
    public void thousand() {
        assertEquals("M", IntegerToRoman.intToRoman(1000));
    }

    @Test
    public void thousandNineHundredFour() {
        assertEquals("MCMIV", IntegerToRoman.intToRoman(1904));
    }

    @Test
    public void twoThousand() {
        assertEquals("MM", IntegerToRoman.intToRoman(2000));
    }
}
