package com.st809.interview.graphs.directed;

import com.st809.interview.graphs.Graph;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;

/**
 * determines if a graph has a cycle
 * This class adds to our standard recursive dfs() a boolean array onStack[]
 * to keep track of the verti- ces for which the recursive call has not completed.
 * When it finds an edge v->w to a vertex w that is on the stack, it has discovered
 * a directed cycle, which it can recover by following edgeTo[] links.
 */
public class DirectedCycle {
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

    public DirectedCycle(Graph g) {
        marked = new boolean[g.V()];
        onStack = new boolean[g.V()];
        edgeTo = new int[g.V()];

        for (int s = 0; s < g.V(); s++) {
            if (!marked[s] && !hasCycle()) {
                dfs(g, s);
            }
        }
    }

    private void dfs(Graph g, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : g.adj(v)) {
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
