package com.st809.interview.questions.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class minSumTest {

    @Test
    public void singleCell() {
        int[][]grid = new int[1][1];
        grid[0][0] = 2;

        assertEquals(2, minSum.minPathSum(grid));
    }

    @Test
    public void twoCells() {
        int[][]grid = new int[2][1];
        grid[0][0] = 2;
        grid[1][0] = 5;

        assertEquals(7, minSum.minPathSum(grid));
    }


    @Test
    public void fourCells() {
        int[][]grid = new int[2][2];
        grid[0][0] = 2;
        grid[0][1] = 8;
        grid[1][0] = 5;
        grid[1][1] = 3;

        assertEquals(10, minSum.minPathSum(grid));
    }

}