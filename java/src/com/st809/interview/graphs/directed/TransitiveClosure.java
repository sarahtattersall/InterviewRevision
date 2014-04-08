package com.st809.interview.graphs.directed;

import com.st809.interview.graphs.Digraph;
import com.st809.interview.graphs.utils.DFSPaths;

public class TransitiveClosure {

    private DFSPaths[] all;

    public TransitiveClosure(Digraph g) {
        all = new DFSPaths[g.V()];
        for (int v = 0; v < g.V(); v++) {
            all[v] = new DFSPaths(g, v);
        }
    }

    /**
     *
     * @param v vertex id in g
     * @param w vertex id in g
     * @return true if v is reachable from w
     */
    boolean reachable(int v, int w) {
        return all[v].hasPathTo(w);
    }
}
