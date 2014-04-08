package com.st809.interview.graphs.directed;

import com.st809.interview.graphs.Graph;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

public class DirectedCycleTest {
    Graph g;

    @Before
    public void setUp() {
        g = new AdjacencyListDigraph(6);
    }

    @Test
    public void noEdges() {
        DirectedCycle cycleDetector = new DirectedCycle(g);
        assertFalse(cycleDetector.hasCycle());
    }

    @Test
    public void noCycle() {
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        DirectedCycle cycleDetector = new DirectedCycle(g);
        assertFalse(cycleDetector.hasCycle());
    }

    @Test
    public void hasCycle() {
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 5);
        g.addEdge(5, 4);
        g.addEdge(4, 2);
        DirectedCycle cycleDetector = new DirectedCycle(g);
        assertTrue(cycleDetector.hasCycle());

    }

    @Test
    public void getCycle() {
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 5);
        g.addEdge(5, 4);
        g.addEdge(4, 2);
        DirectedCycle cycleDetector = new DirectedCycle(g);
        int[] expectedCycle = {4, 2, 3, 5, 4};
        Collection<Integer> cycle = cycleDetector.getCycle();
        assertEquals(expectedCycle.length, cycle.size());
        int index = 0;
        for (int v : cycle) {
            assertEquals(expectedCycle[index], v);
            index++;
        }

    }
}
