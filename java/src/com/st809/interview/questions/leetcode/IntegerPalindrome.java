package com.st809.interview.questions.leetcode;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class IntegerPalindrome {

    /**
     *
     * Uses extra space
     *
     * @param x
     * @return if x is a palindrom
     */
    public static boolean isPalindromeExtraSpace(int x) {
        if (x < 0) {
            return false;
        }

        String str = String.valueOf(x);

        for (int i = 0; i < str.length()/2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * OOPS Bits are not numerical palindromes
     * @param x
     * @return
     */
    public static boolean isPalindromeBitwise(int x) {
        if (x < 0) {
            return false;
        }

        int bits = (int) Math.ceil(Math.log(x));
        for (int bit = 0; bit < bits/2; bit++) {
            int left = (x & (1 << bits - bit)) >> (bits - bit);
            int right = (x & (1 << bit)) >> bit;
            if (left != right) {
                return false;
            }
        }

        return true;

    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int divisor = maxDivisor(x);

        while(x > 0) {
            int left = x / divisor;
            int right = x % 10;
            if (left != right) {
                return false;
            }

            x = (x % divisor) / 10;
            divisor /= 100;
        }
        return true;
    }

    /**
     *
     * @param x
     * @return max base ten divisor
     */
    private static int maxDivisor(int x) {
        int divisor = 1;
        while (x/divisor >= 10) {
            divisor *= 10;
        }


        return divisor;
    }


}
