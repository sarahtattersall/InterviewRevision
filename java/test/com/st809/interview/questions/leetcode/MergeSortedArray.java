package com.st809.interview.questions.leetcode;

public class MergeSortedArray {

    public static void merge(int A[], int m, int B[], int n) {
        int A_old[] = new int[m];
        System.arraycopy(A, 0, A_old, 0, m);

        int a_index = 0;
        int b_index = 0;
        int index = 0;
        while (a_index < m && b_index < n) {
            if (A_old[a_index] < B[b_index]) {
                A[index] = A_old[a_index];
                a_index++;
            } else {
                A[index] = B[b_index];
                b_index++;
            }
            index++;
        }

        while (a_index < m) {
            A[index] = A_old[a_index];
            a_index++;
            index++;
        }

        while (b_index < n) {
            A[index] = B[b_index];
            b_index++;
            index++;
        }
    }

    public static void mergeNoExtraSpace(int A[], int m, int B[], int n) {
        while (n > 0) {
            if (m <= 0 || A[m - 1] < B[n - 1]) {
                A[n + m - 1] = B[n - 1];
                n--;
            } else {
                A[n + m - 1] = A[m - 1];
                m--;
            }
        }
    }
}
