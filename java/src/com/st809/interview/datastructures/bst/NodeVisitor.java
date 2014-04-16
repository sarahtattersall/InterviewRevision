package com.st809.interview.datastructures.bst;

public interface NodeVisitor<Key extends Comparable<Key>, Value> {

    void visit(Node<Key, Value> node);
}
