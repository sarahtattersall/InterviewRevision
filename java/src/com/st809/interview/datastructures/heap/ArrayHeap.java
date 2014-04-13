package com.st809.interview.datastructures.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ArrayHeap implements Heap {
    private List<Integer> heap;

    int size;

    public ArrayHeap(Collection<Integer> numbers) {
        heap = new ArrayList<>(numbers);
        size = numbers.size();
        buildMaxHeap();
    }

    @Override
    public int getParent(int i) {
        return i/2;
    }

    @Override
    public int left(int i) {
        return 2*i + 1;
    }

    @Override
    public int right(int i) {
        return 2*i + 2;
    }

    /**
     * Assumes that binary trees at left and right are max heaps but
     * that heap[node] could be smaller than its children thus violating the
     * max heap property. Max heaap lets the value of heap[node] float
     * down.
     *
     * Starting at a node this takes time O(h) which is O(logn)
     * @param node
     */
    @Override
    public void maxHeapify(int node) {
        int left = left(node);
        int right = right(node);
        int largest; // Index containing the largest of the three i.e. parent, left, right
        if (left < getSize() && heap.get(left) > heap.get(node)) {
            largest = left;
        } else {
            largest = node;
        }
        if (right < getSize()  && heap.get(right) > heap.get(largest)) {
            largest = right;
        }

        if (largest != node) {
            exchange(node, largest);
            maxHeapify(largest);
        }
    }

    /**
     * Exchanges the values at heap[i] and heap[j]
     * @param i
     * @param j
     */
    private void exchange(int i, int j) {
        int tmp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, tmp);
    }

    /**
     * Note that nodes size/2 ... n are the leaves of the heap
     * Therefore for at the start of each iteration each node i+1, i+2, ... n
     * is the root of a max-heap
     *
     * Thus prior to the first iteration each node at  size/2 ... n is a
     * leaft and so a trivial max heap
     * Then in the maintenence stage we call max-heapify to ensure that
     * heaps of size 2 are all max-heaps. Thus decrementing i moves up the heap
     * and maintains the invariant
     * At termination i = 0, each node 1, 2, ...n is the root of a max heap.
     *
     * Runtime is O(nlogn)
     */
    private void buildMaxHeap() {
        for (int i = getSize()/2 - 1; i >= 0; i--) {
            maxHeapify(i);
        }
    }

    private int getSize() {
        return size;
    }

    /**
     *
     * Temporarily modifies the heap to make it a sorted list.
     *
     * Heap sort runs in O(nlogn) and in place. Very good!
     *
     * Calls to buildMaxHeap at the end is only so it remains a max heap
     * after and is not part of the normal algorithm
     * @return sorted list
     */
    public Collection<Integer> sortIntoOrder() {
        buildMaxHeap();
        for (int i = getSize() - 1; i > 0; i--) {
            exchange(0, i);
            size--;
            maxHeapify(0);
        }

        Collection<Integer> result = new ArrayList<>(heap);
        size = result.size();
        buildMaxHeap();
        return result;
    }

    public static void main(String[] args) {
        ArrayHeap arrayHeap = new ArrayHeap(Arrays.asList(1,5,2,3,8,9,12,18,4,5,6));
        Collection<Integer> sorted = arrayHeap.sortIntoOrder();
    }
}
