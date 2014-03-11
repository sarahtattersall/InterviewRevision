package com.st809.interview.datastructures.list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinkedListTest {
    LinkedList<Integer> list;

    @Before
    public void setUp() {
        list = new LinkedList<Integer>();
        for (int i = 0; i < 4; i++) {
            list.insert(i);
        }
    }

    @Test
    public void iterable() {
        int[] values = new int[]{3, 2, 1, 0};
        verifyContains(values);
    }

    private void verifyContains(int[] values) {
        int index = 0;
        for(Integer integer : list) {
            assertEquals(new Integer(values[index]), integer);
            index++;
        }
        assertEquals(values.length, index);
    }

    @Test
    public void deleteFirst() {
        list.delete(3);
        int[] values = new int[]{2, 1, 0};
        verifyContains(values);
    }

    @Test
    public void deleteSecond() {
        list.delete(2);
        int[] values = new int[]{3, 1, 0};
        verifyContains(values);
    }


    @Test
    public void deleteLast() {
        list.delete(0);
        int[] values = new int[]{3, 2, 1};
        verifyContains(values);
    }

    @Test
    public void deleteNotInList() {
        list.delete(4);
        int[] values = new int[]{3, 2, 1, 0};
        verifyContains(values);
    }
}
