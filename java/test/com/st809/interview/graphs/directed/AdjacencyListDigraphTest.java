package com.st809.interview.graphs.directed;

import com.st809.interview.graphs.Digraph;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AdjacencyListDigraphTest {
    AdjacencyListDigraph digraph;

    @Before
    public void setUp() {
        digraph = new AdjacencyListDigraph(2);

    }

    @Test
    public void reversesSimpleGraph() {
        digraph.addEdge(0, 1);
        Digraph reversed = digraph.reverse();
        assertTrue(reversed.adj(0).isEmpty());
        assertEquals(1, reversed.adj(1).size());
        assertTrue(reversed.adj(1).contains(0));

    }

    @Test
    public void addingEdgeIncreasesSize() {
        int e = digraph.E();
        digraph.addEdge(0, 1);
        assertEquals(e + 1, digraph.E());
    }

    @Test
    public void addingEdgeEnsuresSize() {
        digraph.addEdge(0, 1);
        assertEquals(1, digraph.E());
        digraph.addEdge(1, 0);
        assertEquals(2, digraph.E());
    }
}
