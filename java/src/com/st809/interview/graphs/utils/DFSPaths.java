package com.st809.interview.graphs.utils;

import com.st809.interview.graphs.Graph;

import java.util.*;

/**
 * DFS can be used to determine if two verticies are connected
 * E.g. are A and B connected? Trace paths from A (source) and see if B is marked
 * at the end.
 */
public class DFSPaths {
    /**
     * Edges visited
     */
    private boolean[] marked;

    /**
     * Last vertex on know path to the vertex
     */
    private int[] edgeTo;

    /**
     * Source
     */
    private final Set<Integer> sources = new HashSet<>();


    /**
     * Perform DFS on graph starting at the source
     *
     * @param g graph
     * @param s source vertex
     */
    public DFSPaths(Graph g, int s) {
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        sources.add(s);
        dfs(g, s);
    }

    /**
     * Perform DFS on graph starting at the source s
     *
     * @param g       graph
     * @param sources sources vertex
     */
    public DFSPaths(Graph g, Collection<Integer> sources) {
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        this.sources.addAll(sources);
        for (int s : sources) {
            if (!marked[s]) {
                dfs(g, s);
            }
        }
    }


    private void dfs(Graph g, int v) {
        marked[v] = true;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(g, w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Collection<Integer> pathTo(int v) {
        Deque<Integer> path = new ArrayDeque<>();
        if (!hasPathTo(v)) {
            return path;
        }
        int x = v;
        while(!sources.contains(x)) {
            path.push(x);
            x = edgeTo[x];
        }
        path.push(x);
        return path;
    }
}
