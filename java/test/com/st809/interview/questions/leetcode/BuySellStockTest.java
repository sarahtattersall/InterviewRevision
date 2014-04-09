package com.st809.interview.questions.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuySellStockTest {

    @Test
    public void maxProfitNoChange() {
        assertEquals(0, BuySellStock.maxProfit(new int[]{5,5,5,5}));
    }

    @Test
    public void maxProfitZero() {
        assertEquals(0, BuySellStock.maxProfit(new int[]{5, 2}));
    }

    @Test
    public void maxProfit10() {
        assertEquals(10, BuySellStock.maxProfit(new int[]{1, 5, 11}));
    }

    @Test
    public void maxProfit20() {
        assertEquals(20, BuySellStock.maxProfit(new int[]{1, 5, 11, 8, 1, 11}));
    }
}
