package com.st809.interview.questions.leetcode;

/**
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
 * <p/>
 * You have the following 3 operations permitted on a word:
 * <p/>
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 */
public class EditDistance {
    public static void main(String[] args) {
        minDistance("elh", "hel");
    }

    public static int minDistance(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();

        int[][] d = new int[l1 + 1][l2 + 1];

        // the edit distance between an empty string and the prefixes of
        // word2
        for (int i = 0; i <= l2; i++) {
            d[0][i] = i;
        }

        // the edit distance between an empty string and the prefixes of
        // word1
        for (int j = 0; j <= l1; j++) {
            d[j][0] = j;
        }

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                char c1 = word1.charAt(i - 1);
                char c2 = word2.charAt(j - 1);
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    d[i][j] = d[i - 1][j - 1];
                } else {
                    int value = 1 + Math.min(Math.min(d[i][j - 1], d[i - 1][j]), d[i - 1][j - 1]);
                    d[i][j] = value; // min of insertion, deletion, replacement
                }
            }
        }

        return d[l1][l2];
    }
}
