package com.st809.interview.questions.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaximumSubarrayTest {

    @Test
    public void allPositive() {
        assertEquals(6, MaximumSubarray.maxSubArray(new int[]{1,2,3}));
    }


    @Test
    public void oneNegative() {
        assertEquals(6, MaximumSubarray.maxSubArray(new int[]{1,2,3,-1}));
    }


    @Test
    public void oneNegativeInMiddle() {
        assertEquals(5, MaximumSubarray.maxSubArray(new int[]{1,2,-1, 3}));
    }


    @Test
    public void lowNegativeInMiddle() {
        assertEquals(3, MaximumSubarray.maxSubArray(new int[]{1,2,-10, 3}));
    }

    @Test
    public void manyNegative() {
        assertEquals(6, MaximumSubarray.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    @Test
    public void manyNegativeAgain() {
        assertEquals(6, MaximumSubarray.maxSubArray(new int[]{1,2,-1,-2,2,1,-2,1,4,-5,4}));
    }


}
