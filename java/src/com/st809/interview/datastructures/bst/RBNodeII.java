package com.st809.interview.datastructures.bst;

/**
 * A node as described in the Cormet et al. Introduction to algorithms book
 * <p/>
 * We regard null nodes as leaves.
 */
public class RBNodeII<K extends Comparable<K>, V> implements Node<K, V> {
    K key;

    V value;

    /**
     * Left subtree
     */
    RBNodeII<K, V> left;

    /**
     * Right subtree
     */
    RBNodeII<K, V> right;


    /**
     * Nodes parent. Null if root.
     */
    RBNodeII<K, V> parent;

    Color color;


    public RBNodeII(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public Node<K, V> getLeft() {
        return left;
    }

    @Override
    public Node<K, V> getRight() {
        return right;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("(%s %s)", key.toString(), value.toString());
    }

    public static enum Color {
        RED, BLACK
    }
}
