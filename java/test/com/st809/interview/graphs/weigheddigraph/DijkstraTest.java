package com.st809.interview.graphs.weigheddigraph;

import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DijkstraTest {
    private Dijkstra dijkstra;

    @Before
    public void setUp() {
        EdgeWeightedDigraph g = new EdgeWeightedDigraph(6);
        g.addEdge(new DirectedEdge(0, 1, 1));
        g.addEdge(new DirectedEdge(0, 2, 2));
        g.addEdge(new DirectedEdge(1, 3, 3));
        g.addEdge(new DirectedEdge(1, 4, 10));
        g.addEdge(new DirectedEdge(2, 3, 4));
        g.addEdge(new DirectedEdge(3, 4, 5));
        dijkstra = new Dijkstra(g, 0);
    }

    @Test
    public void correctDistanceTo1() {
        assertEquals(1, dijkstra.distanceTo(1), 0.001);
    }


    @Test
    public void correctDistanceTo5() {
        assertEquals(Double.POSITIVE_INFINITY, dijkstra.distanceTo(5), 0.001);
    }

    @Test
    public void correctDistanceTo4() {
        assertEquals(9, dijkstra.distanceTo(4), 0.001);
    }

    @Test
    public void emptyPathTo5() {
        assertTrue(dijkstra.pathTo(5).isEmpty());
    }

    @Test
    public void correctPathTo4() {
        DirectedEdge[] expectedPath = {new DirectedEdge(0, 1, 1), new DirectedEdge(1, 3, 3), new DirectedEdge(3, 4, 5)};
        Collection<DirectedEdge> actualPath = dijkstra.pathTo(4);
        assertEquals(expectedPath.length, actualPath.size());
        int i = 0;
        for (DirectedEdge actualEdge : actualPath) {
            assertEquals(expectedPath[i], actualEdge);
            i++;
        }
    }
}
