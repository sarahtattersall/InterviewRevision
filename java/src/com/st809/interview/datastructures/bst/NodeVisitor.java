package com.st809.interview.datastructures.bst;

public interface NodeVisitor<Key, Value> {

    void visit(BSTNode<Key, Value> node);
}
