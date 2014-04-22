package com.st809.interview.questions.leetcode;

/**
 * Given n, how many structurally unique BST's exist that can store values 1..n?
 * E.g for 3 there are 5
 * 1         3     3      2      1
 *  \       /     /      / \      \
 *   3     2     1      1   3      2
 *  /     /       \                 \
 * 2     1         2                 3
 */
public class UniqueBST {
    /**
     * The answer is infact just a catalan number.
     *
     * Take for instance how many ways of bracketing can we do with n brackets e.g.
     * for n = 1 -> ()
     *     n = 2 -> (()), ()(),
     *     n = 3 -> ()()(), (())(), ((())), ()(()), , (()())
     *
     *  well this can be recursively defines as (x)y where x and y are sub brackets for n - 1
     *  It leads to the formula:
     *  SUM_FROM(i=2)_TO(n-1)_OF(Ci*Cn-1-i)
     *
     *  Which is defined as 1/n+1 (2n choose n)
     *  Which is the same as (2n)!/(n+1)!n!
     *  Which is the same as
     *  PRODUCT_FROM(k=2)_TO(n)_OF((n+k)/k)
     *
     *
     * Note it must be done via the sum due to integer overflow
     *
     * @param n
     * @return number of structurally unique trees for n keys
     */
    public static int numTrees(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] catalanNumbers = new int[n+1];
        catalanNumbers[0] = 1;
        catalanNumbers[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                catalanNumbers[i] += catalanNumbers[j] * catalanNumbers[i-1-j];
            }
        }
        return catalanNumbers[n];
    }

    public static void main(String[] args) {
        numTrees(3);
    }
}
