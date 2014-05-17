package com.st809.interview.questions.leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class minSum {
    public static int minPathSum(int[][] grid) {
        Set<Integer> known = new HashSet<>();
        known.add(0);

        int n = grid.length;
        int m = grid[0].length;
        int[] distances = new int[n*m];

        for (int i = 0; i < n*m; i++) {
            distances[i] = Integer.MAX_VALUE;
        }
        distances[0] = grid[0][0];

        PriorityQueue<DistanceToVertex> queue = new PriorityQueue<>();
        queue.add(new DistanceToVertex(0, 0, grid[0][0]));

        while (!queue.isEmpty()) {
            DistanceToVertex d = queue.poll();
            known.add(coordToInt(grid, d.x, d.y));

            addEdges(d.weight, d.x, d.y, distances, grid, queue);

        }
        return distances[coordToInt(grid, n-1, m-1)];

    }

    public static void addEdges(int weight, int x, int y, int[] distances, int[][] grid, PriorityQueue<DistanceToVertex> queue) {
        if (y + 1 < grid[0].length) {

            addEdge(weight, x, y + 1, grid[x][y+1], distances, grid, queue);
        }
        if (x + 1 < grid.length) {
            addEdge(weight, x + 1, y, grid[x+1][y], distances, grid, queue);
        }
    }

    public static void addEdge(int prevWeight, int x, int y, int weight, int[] distances, int[][]grid, PriorityQueue<DistanceToVertex> queue) {
        if (prevWeight + weight < distances[coordToInt(grid, x, y)]) {
            distances[coordToInt(grid, x, y)] = prevWeight + weight;
            queue.add(new DistanceToVertex(x, y, prevWeight + weight));
        }

    }

    public static class DistanceToVertex implements Comparable<DistanceToVertex> {
        public final int x;
        public final int y;
        public final int weight;

        public DistanceToVertex(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        @Override
        public int compareTo(DistanceToVertex o) {
            return Integer.compare(weight, o.weight);
        }

    }

    public static int coordToInt(int[][] grid, int x, int y) {
        return x * grid[0].length + y;
    }

}
