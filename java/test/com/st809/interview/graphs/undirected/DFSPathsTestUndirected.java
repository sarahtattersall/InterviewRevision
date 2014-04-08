package com.st809.interview.graphs.undirected;

import com.st809.interview.graphs.Graph;
import com.st809.interview.graphs.utils.DFSPaths;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DFSPathsTestUndirected {
    Graph g;

    @Before
    public void setUp() {
        g = new AdjacencyListGraph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(2, 3);
    }

    @Test
    public void path0To3() {
        DFSPaths paths = new DFSPaths(g, 0);
        assertTrue(paths.hasPathTo(3));
    }


    @Test
    public void path0To3Is() {
        DFSPaths paths = new DFSPaths(g, 0);
        int[] expectedPath = {0, 2, 3};
        Collection<Integer> path = paths.pathTo(3);

        assertEquals(expectedPath.length, path.size());
        int index = 0;
        for (Integer v : path) {
            assertEquals(expectedPath[index], v.intValue());
            index++;
        }
    }

    @Test
    public void findsCyclicPath() {
        g.addEdge(1,3);
        DFSPaths paths = new DFSPaths(g, 0);
        int[] expectedPath = {0, 1, 3, 2};
        Collection<Integer> path = paths.pathTo(2);

        assertEquals(expectedPath.length, path.size());
        int index = 0;
        for (Integer v : path) {
            assertEquals(expectedPath[index], v.intValue());
            index++;
        }
    }

}
