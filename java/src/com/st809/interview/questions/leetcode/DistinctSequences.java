package com.st809.interview.questions.leetcode;

public class DistinctSequences {

    public static int numDistinct(String S, String T) {
        int[][] table = new int[S.length() + 1][T.length() + 1];

        for (int i = 0; i < S.length(); i++) {
            table[i][0] = 1; //Empty string counts as a subsequnce, you can delete all of S's characters
        }

        for (int s = 1; s <= S.length(); s++) {
            for (int t = 1; t <= T.length(); t++) {
                if (S.charAt(s - 1) == T.charAt(t - 1)) {
                    table[s][t] = table[s-1][t-1] + table[s-1][t];
                } else {
                    table[s][t] = table[s-1][t];
                }
            }
        }
        return table[S.length()][T.length()];
    }


    public static int numDistincts(String S, String T) {
        int[][] table = new int[S.length() + 1][T.length() + 1];

        for (int i = 0; i < S.length(); i++)
            table[i][0] = 1;

        for (int i = 1; i <= S.length(); i++) {
            for (int j = 1; j <= T.length(); j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    table[i][j] += table[i - 1][j] + table[i - 1][j - 1];
                } else {
                    table[i][j] += table[i - 1][j];
                }
            }
        }

        return table[S.length()][T.length()];
    }

    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit"));
    }
}
