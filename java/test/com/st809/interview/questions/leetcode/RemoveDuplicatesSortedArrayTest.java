package com.st809.interview.questions.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemoveDuplicatesSortedArrayTest {

    @Test
    public void noDups() {
        int[] A = {1,2,3,4,5};
        int newSize = RemoveDuplicatesSortedArray.removeDuplicates(A);
        assertEquals("Wrong size", 5, newSize);
        assertArrayEquals(A, new int[]{1,2,3,4,5});
    }

    @Test
    public void oneDup() {
        int[] A = {1,2,3,4,5,5};
        int newSize = RemoveDuplicatesSortedArray.removeDuplicates(A);
        assertEquals("Wrong size", 5, newSize);
        assertArrayEquals(A, new int[]{1,2,3,4,5});
    }


    @Test
    public void oneDupMiddle() {
        int[] A = {1,2,3,3,4,5};
        int newSize = RemoveDuplicatesSortedArray.removeDuplicates(A);
        assertEquals("Wrong size", 5, newSize);
        assertArrayEquals(A, new int[]{1,2,3,4,5});
    }

    @Test
    public void allDup() {
        int[] A = {1,1,2,2,2,2,2,2,3,3,4,4,4,4,5,5};
        int newSize = RemoveDuplicatesSortedArray.removeDuplicates(A);
        assertEquals("Wrong size", 5, newSize);
        assertArrayEquals(A, new int[]{1,2,3,4,5});
    }

    @Test
    public void empty() {
        int[] A = {};
        int newSize = RemoveDuplicatesSortedArray.removeDuplicates(A);
        assertEquals("Wrong size", 0, newSize);
    }

    public void assertArrayEquals(int[] A, int[] expected) {
        for (int i  = 0; i < expected.length; i++)  {
            assertEquals("Wrong value at index " + i, expected[i], A[i]);
        }
    }
}
