package com.st809.interview.graphs;

import java.util.Collection;

public interface UndirectedGraph extends Graph {

    /**
     *
     * Add an edge connecting v and w
     * This adds an edge also connecting w and v
     *
     * @param v starting vertex
     * @param w finishing vertex
     */
    void addEdge(int v, int w);

}
