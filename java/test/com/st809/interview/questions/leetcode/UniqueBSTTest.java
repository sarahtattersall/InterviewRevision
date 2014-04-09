package com.st809.interview.questions.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UniqueBSTTest {

    @Test
    public void noKeys() {
        assertEquals(0, UniqueBST.numTrees(0));
    }

    @Test
    public void oneKey() {
        assertEquals(1, UniqueBST.numTrees(1));
    }

    @Test
    public void twoKeys() {
        assertEquals(2, UniqueBST.numTrees(2));
    }

    @Test
    public void threeKeys() {
        assertEquals(5, UniqueBST.numTrees(3));
    }

    @Test
    public void fourKeys() {
        assertEquals(14, UniqueBST.numTrees(4));
    }


    @Test
    public void sevenKeys() {
        assertEquals(429, UniqueBST.numTrees(7));
    }
}

