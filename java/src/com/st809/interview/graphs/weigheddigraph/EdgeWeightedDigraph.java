package com.st809.interview.graphs.weigheddigraph;

import java.util.*;

public class EdgeWeightedDigraph {

    /**
     * Number of verticies in graph
     */
    private final int V;

    /**
     * Number of edges in graph
     */
    private int E;

    private List<List<DirectedEdge>> adjacencyList;

    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        adjacencyList = new ArrayList<>(V);
        for (int v = 0; v < V; v++) {
            adjacencyList.add(new LinkedList<DirectedEdge>());
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    /**
     *
     * Adds edge to digraph
     *
     * @param e
     */
    public void addEdge(DirectedEdge e) {
        adjacencyList.get(e.from()).add(e);
        E++;
    }

    /**
     *
     * @param v
     * @return DirectedEdges that start at v
     */
    public Collection<DirectedEdge> adj(int v) {
        return adjacencyList.get(v);
    }

    /**
     *
     * @return all edges in graph
     */
    public Collection<DirectedEdge> edges() {
        Collection<DirectedEdge> edges = new HashSet<>();
        for (Collection<DirectedEdge> e : adjacencyList) {
            edges.addAll(e);
        }
        return edges;
    }
}
