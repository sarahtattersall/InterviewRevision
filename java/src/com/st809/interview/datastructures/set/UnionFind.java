package com.st809.interview.datastructures.set;

public class UnionFind {
    /**
     * Number of connected components
     */
    private int count;

    /**
     * The parent link of a vertex v. Self loop is the root
     * and defines a component
     */
    private int[] id;

    /**
     * Size of component for roots (size indexed)
     */
    private int[] size;

    /**
     * Initialise count set with integer names 0..N-1
     *
     * Each vertex is its own component
     *
     * @param N no of sets
     */
    public UnionFind(int N) {
        this.count = N;
        id = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) { //Each site is its own component
            id[i] = i;
            size[i] = 1;
        }
    }

    /**
     * Add a connection between p & q
     *
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i==j) {
            return;
        }

        if (size[i] < size[j]) {
            id[i] = j;
            size[j] += size[i];
        } else {
            id[j] = i;
            size[i] += size[j];
        }
        count--;
    }

    /**
     *
     * Follows the links to find the self-loop root
     *
     * @param p
     * @return component identifier for p(0 to count-1)
     */
    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    /**
     * @param p
     * @param q
     * @return true if p and q are in the same component
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);

    }

    /**
     *
     * @return Number of components
     */
    public int count() {
        return count;
    }

}
