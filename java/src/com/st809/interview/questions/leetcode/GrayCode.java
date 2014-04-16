package com.st809.interview.questions.leetcode;

import java.util.ArrayList;

public class GrayCode {

    /**
     * The gray code is a binary numeral system where two successive values differ
     * in only one bit.
     *
     * Given a non-negative integer n representing the total number of bits in the
     * code, print the sequence of gray code. A gray code sequence must begin with 0.
     *
     * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
     *
     * 00 - 0
     * 01 - 1
     * 11 - 3
     * 10 - 2
     *
     * Note:
     *
     * For a given n, a gray code sequence is not uniquely defined.
     *
     * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
     *
     * For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
     */
    public static ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0);
        if (n < 1) {
            return result;
        }

        // Base case n = 1
        result.add(1);

        // Recursive case n > 1
        for (int offset = 1; offset < n; offset++) {

            int x = 1 << offset;
            int currentLength = result.size();

            for (int i = currentLength -1; i >= 0; i--) {
                int value = result.get(i) | x;
                result.add(value);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(grayCode(1));

        System.out.println(grayCode(2));

        System.out.println(grayCode(3));
    }
}
