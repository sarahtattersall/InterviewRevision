package com.st809.interview.graphs.undirected;

import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AdjacencyListGraphTest {
    private static final int VERTEX_COUNT = 10;
    AdjacencyListGraph graph;

    @Before
    public void setUp() {
        graph = new AdjacencyListGraph(VERTEX_COUNT);
    }

    @Test
    public void correctNumberOfVerticies() {
        assertEquals(VERTEX_COUNT, graph.V());
    }

    @Test
    public void noEdgesInitially() {
        assertEquals(0, graph.E());
    }

    @Test
    public void addEdgeIncrementsCount() {
        graph.addEdge(0, 1);
        assertEquals(1, graph.E());
    }

    @Test
    public void addEdgeSetsAdjacentEdgeForBoth() {
        graph.addEdge(0, 1);
        Collection<Integer> adjZero = graph.adj(0);
        assertEquals(1, adjZero.size());
        assertTrue(adjZero.contains(1));
        Collection<Integer> adjOne = graph.adj(1);
        assertEquals(1, adjOne.size());
        assertTrue(adjOne.contains(0));
    }
}
