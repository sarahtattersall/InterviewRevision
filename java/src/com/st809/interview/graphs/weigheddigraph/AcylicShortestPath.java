package com.st809.interview.graphs.weigheddigraph;

import com.st809.interview.graphs.directed.TopologicalOrder;
import com.st809.interview.graphs.weighted.DistanceToVertex;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;

/**
 * Computes shortest path in linear time (E + V) if the graph is acyclic
 * It is therefore preferred to Dijkstra where possible
 */
public class AcylicShortestPath implements ShortestPath {
    private DirectedEdge[] edgeTo;
    private double[] distTo;

    /**
     * Computes the shortest path by taking advantage of visiting the nodes in
     * topological order. Uses the fact that once visited it is not possible to get
     * back to the node and so we have found the nodes shortest path
     */
    public AcylicShortestPath(EdgeWeightedDigraph g, int source) {
        edgeTo = new DirectedEdge[g.V()];
        distTo = new double[g.V()];

        for (int v = 0; v < g.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }

        distTo[source] = 0;

        Topological top = new Topological(g);
        for (int v : top.getOrder()) {
            relax(g, v);
        }
    }

    /**
     * Edge relaxation
     * <p/>
     * To relax an edge v->w means to test if the best know way
     * from the source to w is to go from the source to v and then take the edge from v to w.
     * If it is we update the data structures to indicate it to be the best case
     */
    private void relax(DirectedEdge edge) {
        int v = edge.from();
        int w = edge.to();
        if (distTo[w] > distTo[v] + edge.weight()) {
            distTo[w] = distTo[v] + edge.weight();
            edgeTo[w] = edge;
        }
    }

    /**
     * Vertex relaxation
     *
     * @param g
     * @param v
     */
    private void relax(EdgeWeightedDigraph g, int v) {
        for (DirectedEdge e : g.adj(v)) {
            relax(e);
        }
    }

    public double distanceTo(int v) {
        return distTo[v];
    }

    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    /**
     * @param v
     * @return empty list if no path, else the path in order to v
     */
    public Collection<DirectedEdge> pathTo(int v) {
        Deque<DirectedEdge> path = new ArrayDeque<>();
        if (hasPathTo(v)) {
            for (DirectedEdge edge = edgeTo[v]; edge != null; edge = edgeTo[edge.from()]) {
                path.push(edge);
            }
        }
        return path;
    }

}
