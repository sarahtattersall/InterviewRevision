package com.st809.interview.datastructures.queue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DynamicQueueTest {

    Queue<Integer> queue;

    @Before
    public void setUp() {
       queue = new DynamicQueue<Integer>();
    }

    @Test
    public void single() {
        queue.enqueue(5);
        assertEquals(new Integer(5), queue.dequeue());
    }

    @Test
    public void FIFO() {
        for (int i = 0; i < 4; i++) {
            queue.enqueue(i);
        }

        for (int i = 0; i < 4; i++) {
            assertEquals(new Integer(i), queue.dequeue());
        }
    }
}
