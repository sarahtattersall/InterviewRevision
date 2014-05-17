package com.st809.interview.skeina.graphs;

import java.util.HashMap;
import java.util.Map;

public class TwoColor extends Traverse {

    Map<Integer, Color> colors = new HashMap<>();

    private static enum Color {
        UNCOLORED, BLUE, RED
    }

    private boolean bipartide = true;

    public void process(Graph g) {
        for (int vertex : g.verticies()) {
            colors.put(vertex, Color.UNCOLORED);
        }

        bipartide = true;
        initialise(g);
        for (int vertex : g.verticies()) {
            if (states.get(vertex) == State.UNDISCOVERED) {
                colors.put(vertex, Color.BLUE);
                bfs(g, vertex);
            }
        }
    }

    @Override
    protected void processLate(int vertex) {

    }

    @Override
    protected void processEarly(int vertex) {

    }

    @Override
    protected void processEdge(int x, int y) {
        if (colors.get(x) == colors.get(y)) {
            bipartide = false;
            System.out.println("Not bipartite");
        }

        colors.put(y, complement(colors.get(x)));
    }

    private Color complement(Color color) {
        return (color == Color.BLUE) ? Color.RED : Color.BLUE;
    }

    public static void main(String[] args) {
       Graph g = new Graph(true);
        g.insertEdge(1, 2);
        g.insertEdge(2, 3);
        g.insertEdge(1, 4);
        g.insertEdge(4, 3);
//        g.insertEdge(3, 1);

        TwoColor color = new TwoColor();
        color.process(g);
        System.out.println("Two color result " + color.bipartide);
    }
}
