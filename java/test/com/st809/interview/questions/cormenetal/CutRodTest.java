package com.st809.interview.questions.cormenetal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CutRodTest {

    private static final int[] PRICES = {1,5,8,9,10,17,17,20,24,30};


    @Test
    public void zero() {
        assertEquals(0, CutRod.cutRod(PRICES, 0));
    }

    @Test
    public void one() {
        assertEquals(1, CutRod.cutRod(PRICES, 1));
    }

    @Test
    public void two() {
        assertEquals(5, CutRod.cutRod(PRICES, 2));
    }

    @Test
    public void three() {
        assertEquals(8, CutRod.cutRod(PRICES, 3));
    }

    @Test
    public void four() {
        assertEquals(10, CutRod.cutRod(PRICES, 4));
    }

    @Test
    public void five() {
        assertEquals(13, CutRod.cutRod(PRICES, 5));
    }

    @Test
    public void six() {
        assertEquals(17, CutRod.cutRod(PRICES, 6));
    }

    @Test
    public void seven() {
        assertEquals(18, CutRod.cutRod(PRICES, 7));
    }

    @Test
    public void eight() {
        assertEquals(22, CutRod.cutRod(PRICES, 8));
    }

    @Test
    public void nine() {
        assertEquals(25, CutRod.cutRod(PRICES, 9));
    }

    @Test
    public void ten() {
        assertEquals(30, CutRod.cutRod(PRICES, 10));
    }
}
