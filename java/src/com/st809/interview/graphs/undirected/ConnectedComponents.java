package com.st809.interview.graphs.undirected;

import com.st809.interview.graphs.Graph;

public class ConnectedComponents {
    /**
     * Determines if a vertex v has been seen before
     */
    private boolean[] marked;

    /**
     * Which component each vertex falls in
     */
    private int[] id;

    /**
     * Number of connected subgraphs
     */
    private int count;

    /**
     * Finds an unmarked vertex and calls the recursive dfs() to mark and identify all the vertices connected to it,
     * continuing until all vertices have been marked and identified
     * @param g
     */
    public ConnectedComponents(Graph g) {
        marked = new boolean[g.V()];
        id = new int[g.V()];
        for (int s = 0; s < g.V(); s++) {
            if (!marked[s]) {
                dfs(g, s);
                count++;
            }
        }
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                dfs(g, w);
            }
        }
    }

    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    public int id(int v) {
        return id[v];
    }

    public int count() {
        return count;
    }
}
