package com.st809.interview.graphs.weighted;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * The eager version of Prim’s algorithm uses ex- tra space proportional to V and time proportional to
 * E log V (in the worst case) to compute the MST of a connected edge- weighted graph with E edges and V vertices.
 */
public class PrimMST implements MST {
    private Edge[] edgeTo;
    private double[] distTo;
    private boolean[] marked;
    private PriorityQueue<DistanceToVertex> priorityQueue;

    public PrimMST(EdgeWeighedGraph g) {
        edgeTo = new Edge[g.V()];
        distTo = new double[g.V()];
        marked = new boolean[g.V()];
        for (int v = 0; v < g.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }

        priorityQueue = new PriorityQueue<>(g.V());

        distTo[0] = 0.0;
        priorityQueue.add(new DistanceToVertex(0, 0.0));

        while(!priorityQueue.isEmpty()) {
            visit(g, priorityQueue.poll().vertex);
        }

    }

    private void visit(EdgeWeighedGraph g, int v) {
        marked[v] = true;
        for (Edge e : g.adj(v)) {
            int w = e.other(v);
            if (!marked[w] && e.weight() < distTo[w]) {
                edgeTo[w] = e;
                distTo[w] = e.weight();
                DistanceToVertex vertex = new DistanceToVertex(w, distTo[w]);
                if (priorityQueue.contains(vertex)) { // Remove existing distance
                   priorityQueue.remove(vertex);
                }
                priorityQueue.add(vertex);
            }

        }

    }

    @Override
    public Collection<Edge> edges() {
        Deque<Edge> mst = new ArrayDeque<>();
        for (int v = 0; v < edgeTo.length; v++) {
            Edge e = edgeTo[v];
            if (e != null) {
                mst.add(e);
            }
        }
        return mst;
    }

    @Override
    public double weight() {
        double weight = 0.0;
        for (Edge e : edges())
            weight += e.weight();
        return weight;
    }

    /**
     * Node for Priority Queue that sorts verticies based on their distance
     */
    private static class DistanceToVertex implements Comparable<DistanceToVertex> {
        public int vertex;
        public double distance;


        private DistanceToVertex(int vertex, double distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        private DistanceToVertex(int vertex) {
            this.vertex = vertex;
            this.distance = 0;
        }


        @Override
        public int compareTo(DistanceToVertex o) {
            return Double.compare(distance, o.distance);
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof DistanceToVertex)) {
                return false;
            }

            DistanceToVertex that = (DistanceToVertex) o;

            if (vertex != that.vertex) {
                return false;
            }

            return true;
        }

        @Override
        public int hashCode() {
            return vertex;
        }
    }
}
