package com.st809.interview.graphs.weigheddigraph;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EdgeWeightedDigraphTest {
    EdgeWeightedDigraph graph;

    @Before
    public void setUp() {
        graph = new EdgeWeightedDigraph(6);

        graph.addEdge(new DirectedEdge(0, 1, 1));
        graph.addEdge(new DirectedEdge(0, 2, 2));
        graph.addEdge(new DirectedEdge(1, 3, 3));
        graph.addEdge(new DirectedEdge(1, 4, 10));
        graph.addEdge(new DirectedEdge(2, 3, 4));
        graph.addEdge(new DirectedEdge(3, 4, 5));
    }

    @Test
    public void correctNumberOfVertices() {
        assertEquals(6, graph.V());
    }

    @Test
    public void correctNumberOfEdges() {
        assertEquals(6, graph.E());
    }

    @Test
    public void correctAdjacentEdgesFor0() {
        Set<DirectedEdge> expectedEdges = new HashSet<>();
        expectedEdges.addAll(Arrays.asList(new DirectedEdge(0, 1, 1), new DirectedEdge(0, 2, 2)));
        Collection<DirectedEdge> actualEdges = graph.adj(0);
        assertEquals(expectedEdges.size(), actualEdges.size());
        for (DirectedEdge edge : actualEdges) {
            assertTrue(expectedEdges.contains(edge));
            expectedEdges.remove(edge);
        }
    }
}
