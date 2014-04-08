package com.st809.interview.graphs.weigheddigraph;

import java.util.Collection;

public interface ShortestPath {

    /**
     *
     * @param v
     * @return distance from the source to v, infinity if no path
     */
    double distanceTo(int v);

    /**
     *
     * @param v
     * @return true if there is a path from the source to v
     */
    boolean hasPathTo(int v);

    /**
     *
     * @param v
     * @return path from source to v, empty if none
     */
    Collection<DirectedEdge> pathTo(int v);

}
