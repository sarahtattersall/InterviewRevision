package com.st809.interview.graphs.weighted;

import java.util.Collection;

public interface MST {
    /**
     *
     * @return All edges in the MST
     */
    Collection<Edge> edges();

    /**
     *
     * @return total weight of MST
     */
    double weight();
}
