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

    @Test
    public void zeroTopDown() {
        assertEquals(0, CutRod.memoizeCutRod(PRICES, 0));
    }

    @Test
    public void oneTopDown() {
        assertEquals(1, CutRod.memoizeCutRod(PRICES, 1));
    }

    @Test
    public void twoTopDown() {
        assertEquals(5, CutRod.memoizeCutRod(PRICES, 2));
    }

    @Test
    public void threeTopDown() {
        assertEquals(8, CutRod.memoizeCutRod(PRICES, 3));
    }

    @Test
    public void fourTopDown() {
        assertEquals(10, CutRod.memoizeCutRod(PRICES, 4));
    }

    @Test
    public void fiveTopDown() {
        assertEquals(13, CutRod.memoizeCutRod(PRICES, 5));
    }

    @Test
    public void sixTopDown() {
        assertEquals(17, CutRod.memoizeCutRod(PRICES, 6));
    }

    @Test
    public void sevenTopDown() {
        assertEquals(18, CutRod.memoizeCutRod(PRICES, 7));
    }

    @Test
    public void eightTopDown() {
        assertEquals(22, CutRod.memoizeCutRod(PRICES, 8));
    }

    @Test
    public void nineTopDown() {
        assertEquals(25, CutRod.memoizeCutRod(PRICES, 9));
    }

    @Test
    public void tenTopDown() {
        assertEquals(30, CutRod.memoizeCutRod(PRICES, 10));
    }

    @Test
    public void zeroBottomUp() {
        assertEquals(0, CutRod.memoizeCutRodBottomUp(PRICES, 0));
    }

    @Test
    public void oneBottomUp() {
        assertEquals(1, CutRod.memoizeCutRodBottomUp(PRICES, 1));
    }

    @Test
    public void twoBottomUp() {
        assertEquals(5, CutRod.memoizeCutRodBottomUp(PRICES, 2));
    }

    @Test
    public void threeBottomUp() {
        assertEquals(8, CutRod.memoizeCutRodBottomUp(PRICES, 3));
    }

    @Test
    public void fourBottomUp() {
        assertEquals(10, CutRod.memoizeCutRodBottomUp(PRICES, 4));
    }

    @Test
    public void fiveBottomUp() {
        assertEquals(13, CutRod.memoizeCutRodBottomUp(PRICES, 5));
    }

    @Test
    public void sixBottomUp() {
        assertEquals(17, CutRod.memoizeCutRodBottomUp(PRICES, 6));
    }

    @Test
    public void sevenBottomUp() {
        assertEquals(18, CutRod.memoizeCutRodBottomUp(PRICES, 7));
    }

    @Test
    public void eightBottomUp() {
        assertEquals(22, CutRod.memoizeCutRodBottomUp(PRICES, 8));
    }

    @Test
    public void nineBottomUp() {
        assertEquals(25, CutRod.memoizeCutRodBottomUp(PRICES, 9));
    }

    @Test
    public void tenBottomUp() {
        assertEquals(30, CutRod.memoizeCutRodBottomUp(PRICES, 10));
    }
}
