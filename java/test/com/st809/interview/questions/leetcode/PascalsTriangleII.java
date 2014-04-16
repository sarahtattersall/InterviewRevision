package com.st809.interview.questions.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an index k, return the kth row of the Pascal's triangle.

 * For example, given k = 3,
 * Return [1,3,3,1].

 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalsTriangleII {

    public static ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            result.add(result.get(i-1) * (rowIndex - i + 1)/i );
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> row1 = getRow(18);
        System.out.println(row1);
    }
}
