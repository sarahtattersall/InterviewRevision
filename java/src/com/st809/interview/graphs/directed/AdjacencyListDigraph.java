package com.st809.interview.graphs.directed;

import com.st809.interview.graphs.Digraph;
import com.st809.interview.graphs.undirected.AdjacencyListGraph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class AdjacencyListDigraph implements Digraph {
    /**
     * Number of verticies in graph
     */
    private final int V;

    /**
     * Number of edges in graph
     */
    private int E;

    /**
     * Vertex to adjacent verticies. I.e v -> w
     */
    private List<List<Integer>> adjacencyList;

    /**
     *
     * @param V verticies
     */
    public AdjacencyListDigraph(int V) {
        this.V = V;
        this.E = 0;
        this.adjacencyList = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adjacencyList.add(new LinkedList<Integer>());
        }
    }

    @Override
    public Digraph reverse() {
        AdjacencyListDigraph reversedGraph = new AdjacencyListDigraph(V);
        for (int v = 0; v < V; v++) {
            for (int w : adj(v)) {
                reversedGraph.addEdge(w, v);
            }
        }
        return reversedGraph;
    }

    @Override
    public int V() {
        return V;
    }

    @Override
    public int E() {
        return E;
    }

    @Override
    public void addEdge(int v, int w) {
        adjacencyList.get(v).add(w);
        E++;
    }

    @Override
    public Collection<Integer> adj(int v) {
        return adjacencyList.get(v);
    }
}
