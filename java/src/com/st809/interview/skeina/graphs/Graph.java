package com.st809.interview.skeina.graphs;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Graph {
    /**
     * Adjacency info for vertex i
     */
    Map<Integer, EdgeNode> edges = new HashMap<>();

    /**
     * Out degree of each vertex, maps vertex number to degree
     */
    Map<Integer, Integer> degree = new HashMap<>();

    /**
     * Number of verticies
     */
    int verticiesCount = 0;

    /**
     * Number of edges
     */
    int edgesCount = 0;

    /**
     * Represents if graph is directed
     */
    boolean directed;

    public Graph(boolean directed) {
        this.directed = directed;
    }

    public void insertEdge(int x, int y) {
        insertEdge(x, y, directed);
    }

    private void insertEdge(int x, int y, boolean directed) {
        EdgeNode edgeNode = new EdgeNode(y, 0);
        if (edges.containsKey(x)) {
            edgeNode.next = edges.get(x);
            degree.put(x, degree.get(x) + 1);
        } else {
            degree.put(x, 1);
        }
        edges.put(x, edgeNode);

        if (!edges.containsKey(y)) {
            edges.put(y, null);
        }

        if (!directed) {
            insertEdge(y, x, true);
        } else {
            edgesCount++;
        }
    }

    public void printGraph() {
        for (Map.Entry<Integer, EdgeNode> vertex : edges.entrySet()) {
            EdgeNode node = vertex.getValue();
            System.out.print(String.format("Edge from %d to verticies: ", vertex.getKey()));
            while(node != null) {
                System.out.print(" " + node.y);
                node = node.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(false);
        g.insertEdge(0, 1);
        g.insertEdge(2, 0);
        g.printGraph();
    }

    public Collection<Integer> verticies() {
        return edges.keySet();
    }

    public EdgeNode edges(int vertex) {
        return edges.get(vertex);
    }

    public boolean isDirected() {
        return directed;
    }
}
