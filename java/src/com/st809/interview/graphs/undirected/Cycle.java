package com.st809.interview.graphs.undirected;

import com.st809.interview.graphs.Graph;

/**
 * determines if a graph has a cycle
 */
public class Cycle {
    /**
     * If we have looked at v before
     */
    private boolean[] marked;

    /**
     * true if cycle found in graph
     */
    private boolean hasCycle = false;

    public Cycle(Graph g) {
        marked = new boolean[g.V()];
        for (int s = 0; s < g.V(); s++) {
            if (!marked[s] && !hasCycle) {
                dfs(g, s, s);
            }
        }
    }

    private void dfs(Graph g, int v, int parent) {
        marked[v] = true;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                dfs(g, w, v);
            } else if (parent != w) {
                hasCycle = true;
                break;
            }
        }
    }

    public boolean hasCycle() {
        return hasCycle;
    }
}
