package com.st809.interview.graphs.undirected;

import com.st809.interview.graphs.Graph;

public class GraphUtils {
    private GraphUtils() {}

    /**
     *
     * @param g graph
     * @param v vertex in graph
     * @return degree of v
     */
    public static int degree(Graph g, int v) {
        int degree = 0;
        for (int w : g.adj(v)) {
            degree++;
        }
        return degree;
    }

    /**
     *
     * @param g graph
     * @return the maximum degree in the graph
     */
    public static int maxDegree(Graph g) {
        int max = 0;
        for (int v = 0; v < g.V(); v++) {
            int deg = degree(g, v);
            if (deg > max) {
                max = deg;
            }
        }
        return max;
    }

    /**
     * @param g graph
     * @return the average degree of the verticies in the graph
     */
    public static int averageDegree(Graph g) {
        return 2 * g.E() / g.V();
    }
}
