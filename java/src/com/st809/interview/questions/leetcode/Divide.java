package com.st809.interview.questions.leetcode;

/**
 * Divide two integers without using multiplication, division and mod operator.
 */
public class Divide {
    public static int divide(int dividend, int divisor) {
        if (divisor == 1) {
            return dividend;
        }
        int multiplier = 1;
        if (dividend < 0) {
            multiplier *= -1;
            dividend *= -1;
        }
        if (divisor < 0) {
            multiplier *= -1;
            divisor *= -1;
        }

        int result = 0;
        while (dividend - divisor >= 0) {
            dividend -= divisor;
            result++;
        }
        return multiplier * result;
    }
}
