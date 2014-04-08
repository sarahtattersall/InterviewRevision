package com.st809.interview.graphs.directed;

import com.st809.interview.graphs.Digraph;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Finds a topological order for the graph so long as its a DAG
 */
public class TopologicalOrder {
    private Collection<Integer> order = new LinkedList<>();

    public TopologicalOrder(Digraph g) {
        DirectedCycle cycleFinder = new DirectedCycle(g);
        if (!cycleFinder.hasCycle()) {
            DFSOrder dfs = new DFSOrder(g);
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
