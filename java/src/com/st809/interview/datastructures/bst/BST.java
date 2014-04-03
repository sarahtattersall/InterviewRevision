package com.st809.interview.datastructures.bst;

public interface BST<Key extends Comparable<Key>, Value> {
    Value get(Key key);

    void put(Key key, Value value);

    void delete(Key key);

    void inOrder(NodeVisitor<Key, Value> visitor);

    void preOrder(NodeVisitor<Key, Value> visitor);

    void postOrder(NodeVisitor<Key, Value> visitor);
}
