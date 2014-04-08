package com.st809.interview.graphs.weighted;

import java.util.*;

/**
 * Edge weighted graph is undirected graph consisting of edges with weights
 */
public class EdgeWeighedGraph {

    /**
     * Number of verticies
     */
    private final int V;

    /**
     * Number of edges
     */
    private int E;

    /**
     * Adjacency list of edges
     */
    private List<List<Edge>> adjacencyList;

    public EdgeWeighedGraph(int V) {
        this.V = V;
        this.E = 0;
        adjacencyList = new ArrayList<>(V);
        for (int v = 0; v < V; v++) {
            adjacencyList.add(new LinkedList<Edge>());
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    /**
     * Add an edge to this graph
     * @param e
     */
    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        adjacencyList.get(v).add(e);
        adjacencyList.get(w).add(e);
        E++;
    }

    /**
     *
     * @param v
     * @return edges incident to v
     */
    public Collection<Edge> adj(int v) {
        return adjacencyList.get(v);
    }

    /**
     * @return all this graphs edges
     */
    public Collection<Edge> edges() {
        Collection<Edge> edges = new HashSet<>();
        for (int v = 0; v < V; v++) {
            for (Edge e : adj(v)) {
                if (e.other(v) > v) {
                    edges.add(e);
                }
            }
        }
        return edges;
    }
}
