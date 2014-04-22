package com.st809.interview.questions.cormenetal;

/**
 * An example of dynamic programming by solving the solution
 * for an optimal sub problem and combining these results to form an optimal solution
 * of a problem
 */
public class CutRod {

    /**
     *
     * Top down cut rod implementation (NOT DYNAMIC)
     *
     * This algorithm is limited input times become large for numbers > 40
     * CutRod is inefficient because it calls itself recursively over and over again with the same parameter values
     * thus solving the same sub-problems repeatedly.
     *
     * Runtime is exponential in n
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

    /**
     * DYNAMIC implementation of cutRod. This method is a top down solution.
     *
     * It works by arranging each subproblem to be solved only once. If we need to refer
     * to this subproblem again we look it up in a table. It is a good example of a time-memory trade off
     *
     * It runs in polynomial time O(n^2)
     *
     * @param p prices for the rod being i inches in size for 1 <= i <= n
     * @param n size of the rod
     * @return maximum amount we can make from cutting the rod 0 <= i < n times
     */
    public static int memoizeCutRod(int[] p, int n) {
        int[] r = new int[p.length + 1];
        for (int i = 0; i <= p.length; i++) {
            r[i] = Integer.MIN_VALUE;
        }
        return memoizeCutRodAux(p, n, r);
    }

    private static int memoizeCutRodAux(int[] p, int n, int[] r) {
        if (r[n] >= 0) {
            return r[n];
        }

        int q;
        if (n == 0) {
            q = 0;
        } else {
            q = Integer.MIN_VALUE;
        }

        for (int i = 1; i <= n; i++) {
            q = Math.max(q, p[i-1] + memoizeCutRodAux(p, n - i, r));
        }
        r[n] = q;
        return q;
    }

    /**
     * Bottom up DYNAMIC programming version of cutRod.
     *
     * It uses the natural ordering of the subproblems: a problem of size i is "smaller" than
     * a subproblem of size j if i < j.
     * @param p
     * @param n
     * @return
     */
    public static int memoizeCutRodBottomUp(int[] p, int n) {
        int[] r = new int[p.length + 1];
        r[0] = 0;
        for (int j = 1; j <= n; j++) {
            int q = Integer.MIN_VALUE;
            for (int i = 1; i <= j; i++) {
                q = Math.max(q, p[i-1] + r[j-i]);
            }
            r[j] = q;
        }
        return r[n];

    }

}
