package com.st809.interview.graphs.weighted;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PrimMSTTest {
    private PrimMST mst;

    @Before
    public void setUp() {
        EdgeWeighedGraph g = new EdgeWeighedGraph(5);
        g.addEdge(new Edge(0, 1, 5));
        g.addEdge(new Edge(0, 2, 2));
        g.addEdge(new Edge(0, 3, 6));
        g.addEdge(new Edge(1, 2, 1));
        g.addEdge(new Edge(1, 4, 3));
        g.addEdge(new Edge(2, 4, 4));
        g.addEdge(new Edge(3, 4, 7));

        mst = new PrimMST(g);
    }

    @Test
    public void correctMSTWeight() {
        assertEquals(12, mst.weight(), 0.001);
    }

    @Test
    public void correctEdges() {
        Set<Edge> expectedEdges = new HashSet<>();
        expectedEdges.addAll(Arrays.asList(new Edge(0, 2, 2), new Edge(1, 2, 1), new Edge(1, 4, 3), new Edge(0, 3, 6)));
        Collection<Edge> actualEdges = mst.edges();

        assertEquals(expectedEdges.size(), actualEdges.size());
        for (Edge e : actualEdges) {
            assertTrue(expectedEdges.contains(e));
            expectedEdges.remove(e);
        }

    }

}
