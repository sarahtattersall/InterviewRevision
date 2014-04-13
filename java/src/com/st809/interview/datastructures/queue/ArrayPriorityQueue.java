package com.st809.interview.datastructures.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * Based on the Heap algorithm
 */
public class ArrayPriorityQueue<T extends Comparable<T>> implements PriorityQueue<T> {

    private final List<T> queue = new ArrayList<>();

    /**
     * Insert item at the end of the queue then bubble it up
     * @param item
     */
    @Override
    public void insert(T item) {
        queue.add(item);
        int index = queue.size()-1;
        while(index > 0 && smaller(parent(index), index)) {
            swap(parent(index), index);
            index = parent(index);
        }
    }

    private int parent(int index) {
        return (index - 1)/2;
    }

    @Override
    public T maximum() {
        return queue.get(0);
    }

    /**
     * Removes first item, moves last element to the head and then calls maxHeapify
     * once giving a runtime of O(logn)
     * @return head of queue (ie max item)
     */
    @Override
    public T extractMax() {
        if (queue.isEmpty()) {
            throw new RuntimeException("Cannot extract max from empty queue");
        }
        T max = queue.get(0);
        queue.set(0, queue.get(queue.size() - 1));
        queue.remove(queue.size() - 1);
        maxHeapify(0);
        return max;
    }

    private void maxHeapify(int node) {
        int left = getLeft(node);
        int right = getRight(node);

        int largest = node;
        if (left < queue.size() && larger(left, node)) {
            largest = left;
        }
        if (right < queue.size() && larger(right, largest)) {
            largest = right;
        }

        if (!queue.get(node).equals(queue.get(largest))) {
            swap(node, largest);
            maxHeapify(largest);
        }
    }



    /**
     * Swap queue[i] and queue[j]
     *
     * @param i
     * @param j
     */
    private void swap(int i, int j) {
        T tmp = queue.get(i);
        queue.set(i, queue.get(j));
        queue.set(j, tmp);
    }

    /**
     * @param i
     * @param j
     * @return true if object at i is greater than object at j
     */
    private boolean larger(int i, int j) {
        return queue.get(i).compareTo(queue.get(j)) > 0;
    }



    /**
     * @param i
     * @param j
     * @return true if object at i is smaller than object at j
     */
    private boolean smaller(int i, int j) {
        return queue.get(i).compareTo(queue.get(j)) < 0;
    }


    /**
     * @param node
     * @return index of left child
     */
    private int getLeft(int node) {
        return 2 * node + 1;
    }

    /**
     * @param node
     * @return index of right child
     */
    private int getRight(int node) {
        return 2 + node + 2;
    }

}
