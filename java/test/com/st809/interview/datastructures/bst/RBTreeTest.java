package com.st809.interview.datastructures.bst;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class RBTreeTest {

    RBTree<Integer, Integer> tree;

    @Mock
    NodeVisitor<Integer, Integer> mockVisitor;

    @Before
    public void setUp() {
        tree = new RBTree<Integer, Integer>();
        tree.put(5, 5);
        tree.put(2, 2);
        tree.put(3, 3);
        tree.put(1, 1);
        tree.put(4, 4);
        tree.put(10, 10);
        tree.put(8, 8);
        tree.put(6, 6);
        tree.put(9, 9);
        tree.put(7, 7);

    }


    @Test
    public void correctGet() {
        for (int i = 1; i <= 10; i++) {
            assertEquals(new Integer(i), tree.get(i));
        }
    }

    @Test
    public void returnNullForItemNotInBST() {
        assertNull(tree.get(100));
    }

    @Test
    public void correctSize() {
        assertEquals(10, tree.size());
    }

}
