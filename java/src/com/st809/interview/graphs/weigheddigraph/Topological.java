package com.st809.interview.graphs.weigheddigraph;

import com.st809.interview.graphs.Digraph;
import com.st809.interview.graphs.directed.DFSOrder;
import com.st809.interview.graphs.directed.DirectedCycle;

import java.util.Collection;
import java.util.LinkedList;

public class Topological {
    private Collection<Integer> order = new LinkedList<>();

    public Topological(EdgeWeightedDigraph g) {
        WeightedCycle cycleFinder = new WeightedCycle(g);
        if (!cycleFinder.hasCycle()) {
            WeightedDFS dfs = new WeightedDFS(g);
            order = dfs.getReversePostStack();
        }
    }

    public Collection<Integer> getOrder() {
        return order;
    }

    public boolean isDAG() {
        return !order.isEmpty();
    }
}
