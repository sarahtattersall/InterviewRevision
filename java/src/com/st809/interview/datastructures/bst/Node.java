package com.st809.interview.datastructures.bst;

public interface Node<Key extends Comparable<Key>, Value>  {
    Node<Key, Value> getLeft();
    Node<Key, Value> getRight();
    Key getKey();
    Value getValue();
}
