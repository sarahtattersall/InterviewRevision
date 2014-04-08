package com.st809.interview.graphs.weighted;

import com.st809.interview.datastructures.set.UnionFind;

import java.util.*;

public class KruskalMST implements MST {
    private Deque<Edge> mst = new ArrayDeque<>();

    public KruskalMST(EdgeWeighedGraph g) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.addAll(g.edges());
        UnionFind uf = new UnionFind(g.V());
        while(!priorityQueue.isEmpty() && mst.size() < g.V() - 1) {
            Edge e = priorityQueue.poll();
            int v = e.either();
            int w = e.other(v);
            if (uf.connected(v, w)) {
                continue;
            }
            uf.union(v, w);
            mst.add(e);
        }
    }

    @Override
    public Collection<Edge> edges() {
        return mst;
    }

    @Override
    public double weight() {
        double weight = 0;
        for (Edge e : edges()) {
            weight += e.weight();
        }
        return weight;
    }
}
