package com.st809.interview.graphs;

import java.util.Collection;

public interface Graph {
    /**
     *
     * @return number of verticies
     */
    int V();

    /**
     *
     * @return number of edges
     */
    int E();

    /**
     *
     * Add an edge connecting v and w
     *
     * @param v starting vertex
     * @param w finishing vertex
     */
    void addEdge(int v, int w);

    /**
     *
     * @param v vertex index
     * @return verticies adjacent to v
     */
    Collection<Integer> adj(int v);
}
