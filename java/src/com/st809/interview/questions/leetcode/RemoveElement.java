package com.st809.interview.questions.leetcode;

/**
 * Given an array and  value, remove all instances of that value in place and return the new length
 *
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class RemoveElement {

    public static int removeElement(int[] A, int elem) {
        int swap = A.length - 1;
        int index = 0;
        while(index <= swap) {
            if (A[index] == elem) {
                swap(index, swap, A);
                swap--;
            } else {
                index++;
            }
        }
        return index;
    }

    /**
     *
     * swaps elements A[i] and A[j]
     *
     * @param i index in A
     * @param j index in A
     * @param A array
     */
    private static void swap(int i, int j, int[] A) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
