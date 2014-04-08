package com.st809.interview.graphs.undirected;

import com.st809.interview.graphs.Graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class AdjacencyListGraph implements Graph {
    private final int V;
    private int E;
    private List<List<Integer>> adjacencyList;

    public AdjacencyListGraph(int V) {
        this.V = V;
        this.E = 0;
        adjacencyList = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adjacencyList.add(new LinkedList<Integer>());
        }
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
        adjacencyList.get(w).add(v);
        E++;
    }

    @Override
    public Collection<Integer> adj(int v) {
        return adjacencyList.get(v);
    }
}
