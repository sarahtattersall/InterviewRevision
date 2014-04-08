package com.st809.interview.graphs.undirected;

import com.st809.interview.graphs.Graph;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CycleTest {
    Graph g;

    @Before
    public void setUp() {
        g = new AdjacencyListGraph(5);
    }

    @Test
    public void noEdges() {
        Cycle cycleDetector = new Cycle(g);
        assertFalse(cycleDetector.hasCycle());
    }

    @Test
    public void noCycle() {
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,4);
        Cycle cycleDetector = new Cycle(g);
        assertFalse(cycleDetector.hasCycle());
    }

    @Test
    public void cycle() {
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,4);
        g.addEdge(2,4);
        Cycle cycleDetector = new Cycle(g);
        assertTrue(cycleDetector.hasCycle());

    }
}
