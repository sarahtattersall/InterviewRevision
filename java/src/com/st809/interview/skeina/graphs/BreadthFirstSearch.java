package com.st809.interview.skeina.graphs;

import java.util.Map;

public class BreadthFirstSearch extends Traverse {


    @Override
    protected void processLate(int vertex) {

    }

    @Override
    protected void processEarly(int vertex) {

    }

    @Override
    protected void processEdge(int x, int y) {

    }

    public static void main(String[] args) {
        Graph g = new Graph(true);
        g.insertEdge(0, 1);
        g.insertEdge(0, 2);
        g.insertEdge(0, 3);
        g.insertEdge(2, 3);
        g.insertEdge(3, 4);
        g.insertEdge(4, 5);
        g.insertEdge(5, 1);
        g.insertEdge(1, 4);

        BreadthFirstSearch bfs = new BreadthFirstSearch();
        Map<Integer, Integer> paths = bfs.bfs(g, 1);
        printPath(1, 5, paths);

    }
}
