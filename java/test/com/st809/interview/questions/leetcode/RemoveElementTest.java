package com.st809.interview.questions.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemoveElementTest {

    @Test
    public void removeNoDuplicates() {
        int[] A = {1,2,3,4,5,6};
        int newSize = RemoveElement.removeElement(A, 7);
        assertEquals(6, newSize);
        int[] expected = {1,2,3,4,5,6};
        assertValuesAre(A, expected);
    }

    @Test
    public void removeOneValue() {
        int[] A = {1,2,3,4,5,6};
        int newSize = RemoveElement.removeElement(A, 4);
        assertEquals(5, newSize);
        int[] expected = {1,2,3,6,5};
        assertValuesAre(A, expected);
    }

    @Test
    public void removeDuplicateValue() {
        int[] A = {1,2,3,4,4,5,4,6,4,4};
        int newSize = RemoveElement.removeElement(A, 4);
        assertEquals(5, newSize);
        int[] expected = {1,2,3,6,5};
        assertValuesAre(A, expected);
    }

    public void assertValuesAre(int[] A, int[] expected) {
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], A[i]);
        }
    }


}
