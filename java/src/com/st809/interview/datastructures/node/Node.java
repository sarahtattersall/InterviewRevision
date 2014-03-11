package com.st809.interview.datastructures.node;

public class Node<T> {


    public Node(T item) {
        this.item = item;
    }

    private T item;

    public Node(T item, Node<T> next) {
        this.item = item;
        this.next = next;
    }

    private Node<T> next;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
