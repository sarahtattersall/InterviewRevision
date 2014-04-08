package com.st809.interview.graphs.weighted;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.PriorityQueue;

public class LazyPrimMST implements MST {

    private final boolean[] marked;
    private final Deque<Edge> mst = new ArrayDeque<>();
    private final PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();

    public LazyPrimMST(EdgeWeighedGraph g) {
        marked = new boolean[g.V()];

        visit(g, 0);

        while(!priorityQueue.isEmpty()) {
            Edge e = priorityQueue.poll();
            int v = e.either();
            int w = e.other(v);
            if (!(marked[v] && marked[w])) {  //Not cyclic
                mst.add(e);
                if (!marked[v]) {
                    visit(g, v);
                }
                if (!marked[w]) {
                    visit(g, w);
                }
            }
        }
    }

    private void visit(EdgeWeighedGraph g, int v) {
        marked[v] = true;
        for (Edge e : g.adj(v)) {
            if (!marked[e.other(v)]) {
                priorityQueue.add(e);
            }
        }
    }

    @Override
    public Collection<Edge> edges() {
        return mst;
    }

    @Override
    public double weight() {
        int weight = 0;
        for (Edge e : mst) {
            weight += e.weight();
        }
        return weight;
    }
}
