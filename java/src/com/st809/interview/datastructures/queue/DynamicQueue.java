package com.st809.interview.datastructures.queue;

import com.st809.interview.datastructures.node.Node;

public class DynamicQueue<T> implements Queue<T> {
    Node<T> first;

    Node<T> last;


    @Override
    public void enqueue(T item) {
        if (last == null) {
            last = new Node<T>(item);
            first = last;
        } else {
            Node<T> oldLast = last;
            last = new Node<T>(item);
            oldLast.setNext(last);
        }
    }

    @Override
    public T dequeue() {
        if (first == null) {
            return null;
        }
        Node<T> tmp = first;
        first = first.getNext();
        return tmp.getItem();

    }
}
