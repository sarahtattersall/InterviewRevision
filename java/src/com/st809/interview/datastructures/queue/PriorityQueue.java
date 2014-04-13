package com.st809.interview.datastructures.queue;

public interface PriorityQueue<T extends Comparable<T>> {

    void insert(T item);
    T maximum();
    T extractMax();

}
