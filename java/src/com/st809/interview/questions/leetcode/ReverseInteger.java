package com.st809.interview.questions.leetcode;

/**
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 */
public class ReverseInteger {

    public static int reverse(int x) {
        boolean overflow = false;
        boolean negative = x < 0;
        if (negative) {
            x *= -1;
        }
        int result = 0;
        while(x > 0) {
            int previous = result;
            result = result * 10 + x % 10;
            if (result < previous)
            {
                overflow = true;
                break;
            }
            x /= 10;
        }

        if (overflow && negative) {
            return Integer.MIN_VALUE;
        }
        if (overflow) {
            return Integer.MAX_VALUE;
        }
        if (negative) {
            result *= -1;
        }
        return  result;
    }

}
