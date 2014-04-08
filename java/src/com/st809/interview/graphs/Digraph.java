package com.st809.interview.graphs;

/**
 * A directional graph where edges have weights
 */
public interface Digraph extends Graph {
    /**
     * The reverse of this Digraph
     * @return
     */
    Digraph reverse();
}
