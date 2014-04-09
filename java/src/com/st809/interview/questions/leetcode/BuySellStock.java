package com.st809.interview.questions.leetcode;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i
 * Design an algorithm to find the max profit. You may complete as many transactions as you like (i.e. buy one
 * sell one share of the stock multiple times). However you may not engage in multiple transations at the same time
 * (i.e. you must sell the stock before you buy again)
 */
public class BuySellStock {
    public static int maxProfit(int[] prices) {
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            int change = prices[i] - prices[i-1];
            if (change > 0) {
                profit += change;
            }
        }
        return profit;

    }
}
