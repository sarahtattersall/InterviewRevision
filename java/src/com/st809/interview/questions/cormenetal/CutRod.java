package com.st809.interview.questions.cormenetal;

/**
 * An example of dynamic programming by solving the solution
 * for an optimal sub problem and combining these results to form an optimal solution
 * of a problem
 */
public class CutRod {

    /**
     *
     * @param p prices for the rod being i inches in size for 1 <= i <= n
     * @param n size of the rod
     * @return maximum amount we can make from cutting the rod 0 <= i < n times
     */
    public static int cutRod(int[] p, int n) {
        if (n == 0) {
            return 0;
        }
        int q = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            q = Math.max(q, p[i - 1] + cutRod(p, n - i));
        }
        return q;
    }
}
