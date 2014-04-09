package com.st809.interview.questions.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SearchInsertPositionTest {
    private static final int[] TEST_ARRAY = {1, 3, 5, 6};

    @Test
    public void testFive() {
        assertEquals(2, SearchInsertPosition.searchInsert(TEST_ARRAY, 5));
    }

    @Test
    public void testOne() {
        assertEquals(0, SearchInsertPosition.searchInsert(TEST_ARRAY, 1));
    }

    @Test
    public void testSix() {
        assertEquals(3, SearchInsertPosition.searchInsert(TEST_ARRAY, 6));
    }

    @Test
    public void testTwo() {
        assertEquals(1, SearchInsertPosition.searchInsert(TEST_ARRAY, 2));
    }

    @Test
    public void testSeven() {
        assertEquals(4, SearchInsertPosition.searchInsert(TEST_ARRAY, 7));
    }

    @Test
    public void testZero() {
        assertEquals(0, SearchInsertPosition.searchInsert(TEST_ARRAY, 0));
    }
}
