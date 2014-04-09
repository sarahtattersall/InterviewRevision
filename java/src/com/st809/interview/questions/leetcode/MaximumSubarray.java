package com.st809.interview.questions.leetcode;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum
 *
 * For example, given the array [-2, 1, -3, 4, -1, 2, 1, -5, 4]
 * the contiguous subarray [4, -1, 2, 1] has the largest sum = 6
 */
public class MaximumSubarray {

    public static int maxSubArray(int[] A) {
        int longest = A[0];
        int sum = A[0];
        for (int i = 1; i < A.length; i++) {
            if (sum < 0) {
                sum = A[i];
            } else {
                sum +=  A[i];
            }

            if (sum > longest) {
                longest = sum;
            }
        }
        return longest;
    }
}
