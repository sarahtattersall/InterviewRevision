package com.st809.interview.graphs.directed;

import com.st809.interview.graphs.Digraph;

/**
 * Two vertices v and w are strongly connected if they are mutually reachable: that is, if there is a directed path
 * from v to w and a directed path from w to v. A digraph is strongly connected if all its vertices are strongly
 * connected to one another
 *
 * This solves it using Kosaraju algorithm which makes use of a DFS. Therefore
 * time is proportional to V + E. The reverse copy of the digraph uses space V + E
 */
public class StronglyConnectedComponents {
    /**
     * If during traverse we've seen vertex v
     */
    private boolean[] marked;

    /**
     * which SCC vertex v falls in
     */
    private int[] id;

    /**
     * Number of SCC's found
     */
    private int count = 0;


    /**
     * Uses Kosaraju algorithm to determine SCC's
     * It is a modified version of the undirected {@link com.st809.interview.graphs.undirected.ConnectedComponents}
     * algorithm.
     *
     * We iterate over the verticies in order of the reverse postorder on g, rather than numerical order
     * @param g
     */
    public StronglyConnectedComponents(Digraph g) {
        marked = new boolean[g.V()];
        id = new int[g.V()];

        DFSOrder order = new DFSOrder(g.reverse());
        for (int s : order.getReversePostStack()) {
            if (!marked[s]) {
                dfs(g, s);
                count++;
            }
        }

    }

    private void dfs(Digraph g, int v) {
        marked[v] = true;
        id[v] = count;

        for (int w : g.adj(v)) {
            if (!marked[w]) {
                dfs(g, w);
            }
        }

    }

    /**
     *
     * @param v
     * @param w
     * @return true if v and w are strongly connected. That is there is a path from v to w and w to v
     *         i.e. a cycle that contains them both
     */
    public boolean stronglyConnected(int v, int w) {
        return id[v] == id[w];
    }

    /**
     *
     * @return number of SCC's found
     */
    int count() {
        return count;
    }

    /**
     *
     * @param v
     * @return number of SCC a vertex falls in
     */
    int id(int v) {
        return id[v];
    }
}
