package com.st809.interview.questions.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClimbStairsTest {

    @Test
    public void oneStep() {
        assertEquals(1, ClimbStairs.climbStairs(1));
    }

    @Test
    public void twoSteps() {
        assertEquals(2, ClimbStairs.climbStairs(2));
    }

    @Test
    public void threeSteps() {
        assertEquals(3, ClimbStairs.climbStairs(3));
    }

    @Test
    public void fourSteps() {
        assertEquals(5, ClimbStairs.climbStairs(4));
    }
}
