package com.st809.interview.questions.leetcode;

/**
 * Given an array with n objects colored red, white or blue, sort them so that the objects of the same color
 * are adjacent, with the colors in the order red, white and blue
 * <p/>
 * Here we will use integers 0, 1 and 2 to represent the color red, white and blue respecitvely.
 * <p/>
 * Note: You are not suppose to use the library's sort function!
 */
public class SortColors {

    /**
     * We can do this in O(n) rather than O(nlogn) because we know the numbers :)
     * This is known as a counting sort
     *
     * @param A
     */
    public static void sortColors(int[] A) {
        int[] colorCounts = new int[3];
        for (int i = 0; i < 3; i++) {
            colorCounts[i] = 0;
        }

        for (int color : A) {        // Count colors
            colorCounts[color]++;
        }

        int index = 0;
        for (int color = 0; color < colorCounts.length; color++) {
            for (int i = 0; i < colorCounts[color]; i++) {
                A[index] = color;
                index++;
            }
        }
    }

    /**
     * Attempts to sort in single pass
     */
    public static void sortColorsII (int[] A) {


        int current = 0;
        int red = 0;
        int blue = A.length -1;

        while (current < blue) {
            if (A[current] == 0) {
                swap(A, current++, red++);
            } else if (A[current] == 2) {
                swap(A, current, blue--);
            } else {
                current++;
            }

        }
    }

    private static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public static void main(String[] args) {
        int[] A = {1,2,1,2,0,0,0,1,0,2,0,1,1,1,0};
        sortColorsII(A);
        printArray(A);
        int[] B = {1,2,1,2,1,2,1,1,1};
        sortColors(B);
        printArray(B);
        int[] C = {};
        sortColors(C);
        printArray(C);
    }

    private static void printArray(int[] a) {
        System.out.print("{");
        for (int value : a) {
            System.out.print(value + ", ");
        }
        System.out.println("}");
    }
}
