package com.st809.interview.datastructures.stack;

import com.st809.interview.datastructures.node.Node;

public class DynamicStack<T> implements Stack<T> {
    private Node<T> head = null;

    @Override
    public void push(T item) {
        if (head == null) {
            head = new Node<T>(item);
        } else {
            head = new Node<T>(item, head);
        }

    }

    @Override
    public T pop() {
        if (head == null) {
            return null;
        }

        Node<T> tmp = head;
        head = head.getNext();
        return tmp.getItem();
    }
}
