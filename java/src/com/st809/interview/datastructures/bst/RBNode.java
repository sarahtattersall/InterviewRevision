package com.st809.interview.datastructures.bst;

public class RBNode<Key extends Comparable<Key>, Value> {
    public Key key;

    public Value value;

    /**
     * Left Subtree
     */
    public RBNode<Key, Value> left;

    /**
     * Right subtree
     */
    public RBNode<Key, Value> right;

    /**
     * Color of this link
     * true => red
     * false => black
     *
     * Default is black link
     */
    boolean color = false;

    /*
     * nodes in subtree rooted here
     */
    public int N;

    public RBNode(Key key, Value value, int N, boolean color) {
        this.key = key;
        this.value = value;
        this.N = N;
        this.color = color;
    }
}
