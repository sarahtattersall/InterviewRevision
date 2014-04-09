package com.st809.interview.questions.leetcode;

/**
 * You are climbing a stair case. It takes n steps to each to the top
 *
 * Each time you can either climb 1 or two steps. In how many distinct ways can you reach the top?
 */
public class ClimbStairs {


    /**
     *
     * This problem equates to finding the nth fibonnaci number.
     * At first recursion looks like the obvious way, but it is slow and causes a time out on the test.
     *
     * An iterative approach is needed
     *
     * @param n number of stairs
     * @return number of different ways to climb the steps
     */
    public static int climbStairs(int n) {
        int n1 = 1;
        int n2 = 1;

        for(int i = 1; i < n; i++) {
            int next = n1 + n2;
            n1 = n2;
            n2 = next;
        }
        return n2;
    }
}
