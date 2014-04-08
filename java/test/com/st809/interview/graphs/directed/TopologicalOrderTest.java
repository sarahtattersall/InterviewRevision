package com.st809.interview.graphs.directed;

import com.st809.interview.graphs.Digraph;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TopologicalOrderTest {
    Digraph g;

    private TopologicalOrder order;

    /**
     * Uses Digraph from pg 579 of Algorithms 4th ed book
     */
    @Before
    public void setUp() {
        g = new AdjacencyListDigraph(13);
        g.addEdge(0, 5);
        g.addEdge(0, 1);
        g.addEdge(0, 6);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 5);
        g.addEdge(5, 4);
        g.addEdge(6, 4);
        g.addEdge(7, 6);
        g.addEdge(8, 7);
        g.addEdge(6, 9);
        g.addEdge(9, 11);
        g.addEdge(9, 12);
        g.addEdge(9, 10);
        g.addEdge(11, 12);
        order = new TopologicalOrder(g);
    }

    @Test
    public void isDag() {
        assertTrue(order.isDAG());
    }

    @Test
    public void order() {
        int[] expectedOrder = {8,7,2,3,0,6,9,10, 11, 12, 1, 5, 4};
        Collection<Integer> actualOrder = order.getOrder();
        assertEquals(expectedOrder.length, actualOrder.size());
        int index = 0;
        for (int o : actualOrder) {
            assertEquals(expectedOrder[index], o);
            index++;
        }
    }
}
