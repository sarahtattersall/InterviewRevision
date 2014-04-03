package com.st809.interview.datastructures.bst;

public class NodePrinter<Key, Value> implements NodeVisitor<Key, Value> {
    @Override
    public void visit(BSTNode<Key, Value> node) {
        System.out.println("(Key: " + node.key + ", Value: " + node.value + ")");
    }
}
