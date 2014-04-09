package com.st809.interview.questions.leetcode;

/**
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 *
 * ExampleS:
 * [1,3,5,6], 5 -> 2
 * [1,3,5,6], 2 -> 1
 * [1,3,5,6], 7 -> 4
 * [1,3,5,6], 0 -> 0
 */
public class SearchInsertPosition {
    public static int searchInsert(int[] A, int target) {
        int left = 0;
        int right = A.length -1;
        while (true) {
            if (left > right) {
                return left;
            }
            int index = (left + right)/2;
            if (A[index] == target) {
                return index;
            }
            if (A[index] > target) {
                right = index -1;
            } else if (A[index] < target) {
                left = index + 1;
            }
        }
    }
}
