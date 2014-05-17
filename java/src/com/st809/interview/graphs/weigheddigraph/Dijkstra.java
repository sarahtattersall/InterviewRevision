package com.st809.interview.graphs.weigheddigraph;

import com.st809.interview.graphs.weighted.DistanceToVertex;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.PriorityQueue;

public class Dijkstra implements ShortestPath {
    /**
     * Smallest recorded distance from source to v
     */
    private double[] distTo;

    /**
     * Edge that leads to v with the smallest weight
     */
    private DirectedEdge[] edgeTo;

    /**
     * Source vertex of graph
     */
    private final int source;

    private final PriorityQueue<DistanceToVertex> queue = new PriorityQueue<>();

    public Dijkstra(EdgeWeightedDigraph g, int source) {
        this.source = source;
        distTo = new double[g.V()];
        edgeTo = new DirectedEdge[g.V()];
        for (int v = 0; v < g.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }

        distTo[source] = 0;
        queue.add(new DistanceToVertex(source, 0));

        while(!queue.isEmpty()) {
            relax(g, queue.poll().vertex);
        }
    }

    @Override
    public double distanceTo(int v) {
        return distTo[v];
    }

    @Override
    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    /**
     * @param v
     * @return empty list if no path, else the path in order to v
     */
    @Override
    public Collection<DirectedEdge> pathTo(int v) {
        Deque<DirectedEdge> path = new ArrayDeque<>();
        if (hasPathTo(v)) {
            for (DirectedEdge edge = edgeTo[v]; edge != null; edge = edgeTo[edge.from()]) {
                path.push(edge);
            }
        }
        return path;
    }


    /**
     * Edge relaxation
     * <p/>
     * To relax an edge v->w means to test if the best known way
     * from the source to w is to go from the source to v and then take the edge from v to w.
     * If it is we update the data structures to indicate it to be the best case
     */
    private void relax(DirectedEdge edge) {
        int v = edge.from();
        int w = edge.to();
        if (distTo[w] > distTo[v] + edge.weight()) {
            distTo[w] = distTo[v] + edge.weight();
            edgeTo[w] = edge;
            DistanceToVertex dist = new DistanceToVertex(w, distTo[w]);
            if (queue.contains(dist)) {
                queue.remove(dist);
            }
            queue.add(dist);
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
}
