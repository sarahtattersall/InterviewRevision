package com.st809.interview.graphs.weigheddigraph;

import com.st809.interview.graphs.Graph;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;

public class WeightedCycle {
    /**
     * If we have looked at v before
     */
    private boolean[] marked;

    /**
     * The edge to vertex v
     */
    private int[] edgeTo;

    /**
     * Verticies on a cycle (if one exists)
     */
    private Deque<Integer> cycle = new ArrayDeque<>();

    /**
     * Verticies on recursive call stack
     */
    private boolean[] onStack;

    public WeightedCycle(EdgeWeightedDigraph g) {
        marked = new boolean[g.V()];
        onStack = new boolean[g.V()];
        edgeTo = new int[g.V()];

        for (int s = 0; s < g.V(); s++) {
            if (!marked[s] && !hasCycle()) {
                dfs(g, s);
            }
        }
    }

    private void dfs(EdgeWeightedDigraph g, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (DirectedEdge edge : g.adj(v)) {
            int w = edge.to();
            if(this.hasCycle()) {
                return;
            }
            else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(g, w);
            } else if (onStack[w]) {
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
                break;
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle() {
        return cycle.size() > 0;
    }

    public Collection<Integer> getCycle() {
        return cycle;
    }
}
