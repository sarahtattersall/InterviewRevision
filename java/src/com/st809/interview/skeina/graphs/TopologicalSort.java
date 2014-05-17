package com.st809.interview.skeina.graphs;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class TopologicalSort extends Traverse

{
    private List<Integer> ordering = new LinkedList<>();

    /**
     * Process DAG
     * @param graph
     * @return ordering
     */
    public Collection<Integer> process(Graph graph) {

        initialise(graph);
        for (int vertex : graph.verticies()) {
            if (states.get(vertex) == State.UNDISCOVERED) {
                dfs(graph, vertex);
            }
        }

        return ordering;
    }

    @Override
    protected void processLate(int vertex) {
        System.out.println("Vertex " + vertex);
        ordering.add(0, vertex);

    }

    @Override
    protected void processEarly(int vertex) {

    }

    @Override
    protected void processEdge(int x, int y) {

    }

    public static void main(String[] args) {
        Graph g = new Graph(true);
        g.insertEdge(1, 2);
        g.insertEdge(1, 3);
        g.insertEdge(2, 4);
        g.insertEdge(3, 4);
        g.insertEdge(4, 5);

        TopologicalSort sort = new TopologicalSort();
        Collection<Integer> ordering = sort.process(g);
        for (int vertex : ordering) {
            System.out.println(vertex);
        }
    }
}
