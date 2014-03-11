package com.st809.interview.datastructures.list;

import com.st809.interview.datastructures.node.Node;

import java.util.Iterator;

public class LinkedList<T> implements List<T>, Iterable<T> {
    private Node<T> head = null;

    @Override
    public void insert(T item) {
        head = new Node<T>(item, head);
    }


    @Override
    public void delete(T item) {
        head = recursiveDelete(head, item);
    }

    /**
     * Recursively search for the node to delete
     *
     * @param node
     * @param item item to delete
     * @return node if not the node to delete, or the nodes next item
     */
    private Node<T> recursiveDelete(Node<T> node, T item) {
        if (node == null) {
            return null;
        }
        if (node.getItem().equals(item)) {
            return node.getNext();
        }
        Node<T> next = recursiveDelete(node.getNext(), item);
        node.setNext(next);
        return node;
    }


    @Override
    public Iterator<T> iterator() {
        return new ListIterator(head);
    }

    private class ListIterator implements  Iterator<T> {

        private Node<T> head;

        public ListIterator(Node<T> head) {

            this.head = head;
        }

        @Override
        public boolean hasNext() {
            return head != null;
        }

        @Override
        public T next() {
            Node<T> tmp = head;
            head = head.getNext();
            return tmp.getItem();
        }

        @Override
        public void remove() {
           // Not implemented
        }
    }
}
