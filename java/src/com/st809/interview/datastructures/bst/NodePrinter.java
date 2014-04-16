package com.st809.interview.datastructures.bst;

public class NodePrinter<Key extends Comparable<Key>, Value> implements NodeVisitor<Key, Value> {
    @Override
    public void visit(Node<Key, Value> node) {
        System.out.println("(Key: " + node.getKey() + ", Value: " + node.getValue() + ")");
    }
}
