package com.st809interview.datastrucures.stack;

import com.st809.interview.datastructures.stack.DynamicStack;
import com.st809.interview.datastructures.stack.Stack;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StackTest {

    Stack<Integer> stack;

    @Before
    public void setUp() {
        stack = new DynamicStack<Integer>();
    }

    @Test
    public void singleElement() {
        stack.push(4);
        assertEquals(new Integer(4), stack.pop());
    }

    @Test
    public void LIFO() {
        for (int i = 0; i < 4; i++) {
            stack.push(i);
        }

        for (int i = 3; i >= 0; i--) {
            assertEquals(new Integer(i), stack.pop());
        }
    }

}
