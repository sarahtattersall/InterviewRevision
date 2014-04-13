package com.st809.interview.datastructures.heap;

public interface Heap {

    int getParent(int i);

    int left(int i);

    int right(int i);

    void maxHeapify(int node);
}
