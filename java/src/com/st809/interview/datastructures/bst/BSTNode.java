package com.st809.interview.datastructures.bst;

public class BSTNode<Key extends Comparable<Key>, Value> implements Node<Key, Value> {
    public Key key;

    public Value value;

    /**
     * Left Subtree
     */
    public BSTNode<Key, Value> left;

    /**
     * Right subtree
     */
    public BSTNode<Key, Value> right;

    /*
     * nodes in subtree rooted here
     */
    public int N;

    public BSTNode(Key key, Value value, int N) {
        this.key = key;
        this.value = value;
        this.N = N;
    }

    @Override
    public Node<Key, Value> getLeft() {
        return left;
    }

    @Override
    public Node<Key, Value> getRight() {
        return right;
    }

    @Override
    public Key getKey() {
        return key;
    }

    @Override
    public Value getValue() {
        return value;
    }
}
