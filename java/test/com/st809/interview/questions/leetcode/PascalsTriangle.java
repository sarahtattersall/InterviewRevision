package com.st809.interview.questions.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5,
 * Return
 * [
 *     [1],
 *    [1,1],
 *   [1,2,1],
 *  [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class PascalsTriangle {

    public static ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> rows = new ArrayList<>();
        if (numRows == 0) {
            return rows;
        }

        rows.add(new ArrayList<>(Arrays.asList(1)));

        for (int row = 1; row < numRows; row++) {
            ArrayList<Integer> previous = rows.get(row - 1);
            Integer[] current = new Integer[row + 1];
            current[0] = 1;
            current[current.length - 1] = 1;
            for (int index = 1; index <= row / 2; index++) {
                int a = previous.get(index - 1);
                int b = (previous.size() > index) ? previous.get(index) : previous.get(index - 1);
                current[index] = a + b;
                current[current.length - 1 - index] = a + b;
            }
            rows.add(new ArrayList<>(Arrays.asList(current)));

        }
        return rows;
    }

    public static void main(String[] args) {
        for (ArrayList<Integer> row : generate(4)) {
            System.out.println(row);
        }
    }
}
