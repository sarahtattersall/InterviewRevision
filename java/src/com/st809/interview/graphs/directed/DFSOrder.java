package com.st809.interview.graphs.directed;

import com.st809.interview.graphs.Digraph;

import java.util.ArrayDeque;
import java.util.Deque;

public class DFSOrder {
    private boolean[] marked;

    public Deque<Integer> getPreQueue() {
        return preQueue;
    }

    public Deque<Integer> getPostQueue() {
        return postQueue;
    }

    public Deque<Integer> getReversePostStack() {
        return reversePostStack;
    }

    private Deque<Integer> preQueue = new ArrayDeque<>();
    private Deque<Integer> postQueue = new ArrayDeque<>();
    private Deque<Integer> reversePostStack = new ArrayDeque<>();

    public DFSOrder(Digraph g) {
        marked = new boolean[g.V()];
        for (int v = 0; v < g.V(); v++) {
            if (!marked[v]) {
                dfs(g, v);
            }
        }
    }

    private void dfs(Digraph g, int v) {
        marked[v] = true;
        preQueue.add(v);
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                dfs(g, w);
            }
        }
        postQueue.add(v);
        reversePostStack.push(v);
    }



}
