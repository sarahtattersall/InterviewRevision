package com.st809.interview.graphs.undirected;

import com.st809.interview.graphs.Graph;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.Queue;

public class BFSPaths {
    /**
     * Determines if a shortest path to this vertex i known
     */
    private boolean[] marked;

    /**
     * The last vertex on a known path to vertex i
     */
    private int[] edgeTo;

    /**
     * source
     */
    private final int s;

    public BFSPaths(Graph g, int s) {
        this.s = s;
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        bfs(g, s);

    }

    private void bfs(Graph g, int v) {
        Queue<Integer> queue = new ArrayDeque<>();
        marked[v] = true;
        queue.add(v);
        while(!queue.isEmpty()) {
            int w = queue.poll();
            for (int x : g.adj(w)) {
                if (!marked[x]) {
                    edgeTo[x] = w;
                    marked[x] = true;
                    queue.add(x);
                }
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
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }

}
