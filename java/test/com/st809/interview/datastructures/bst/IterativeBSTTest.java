package com.st809.interview.datastructures.bst;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.inOrder;

@RunWith(MockitoJUnitRunner.class)
public class IterativeBSTTest {
    IterativeBST<Integer, Integer> bst;

    @Mock
    NodeVisitor<Integer, Integer> mockVisitor;

    @Before
    public void setUp() {
        bst = new IterativeBST<Integer, Integer>();
        bst.put(5, 5);
        bst.put(2, 2);
        bst.put(3, 3);
        bst.put(1, 1);
        bst.put(4, 4);
        bst.put(10, 10);
        bst.put(8, 8);
        bst.put(6, 6);
        bst.put(9, 9);
        bst.put(7, 7);

    }


//    @Test
//    public void correctGet() {
//        for (int i = 1; i <= 10; i++) {
//            assertEquals(new Integer(i), tree.get(i));
//        }
//    }

//    @Test
//    public void returnNullForItemNotInBST() {
//        assertNull(tree.get(100));
//    }
//
//
//
//    @Test
//    public void itemNotInBSTAfterDelete() {
//        tree.delete(5);
//        assertNull(tree.get(5));
//    }


    @Test
    public void inOrderVisit() {
        bst.inOrder(new NodePrinter<Integer, Integer>());
        bst.inOrder(mockVisitor);
        InOrder inOrder = inOrder(mockVisitor);
        int[] ordering = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i : ordering) {
            inOrder.verify(mockVisitor).visit(argThat(hasKeyValue(i, i)));
        }
    }


    @Test
    public void postOrderVisit() {
        bst.postOrder(new NodePrinter<Integer, Integer>());
        bst.postOrder(mockVisitor);
        InOrder inOrder = inOrder(mockVisitor);
        int[] ordering = {1, 4, 3, 2, 7, 6, 9, 8, 10, 5};
        for (int i : ordering) {
            inOrder.verify(mockVisitor).visit(argThat(hasKeyValue(i, i)));
        }
    }

    @Test
    public void preOrderIterativeBSTVisit() {
        bst.preOrder(mockVisitor);
        InOrder inOrder = inOrder(mockVisitor);
        int[] ordering = {5, 2, 1, 3, 4, 10, 8, 6, 7, 9};
        for (int i : ordering) {
            inOrder.verify(mockVisitor).visit(argThat(hasKeyValue(i, i)));
        }
    }


    private NodeMatcher<Integer, Integer> hasKeyValue(int key, int value) {
        return new NodeMatcher<Integer, Integer>(key, value);
    }

    class NodeMatcher<Key, Value> extends ArgumentMatcher<BSTNode<Key, Value>> {
        Key key;

        NodeMatcher(Key key, Value value) {
            this.key = key;
            this.value = value;
        }

        Value value;

        @Override
        public boolean matches(Object argument) {
            BSTNode<Key, Value> node = (BSTNode<Key, Value>) argument;
            return node.key.equals(key) && node.value.equals(value);
        }
    }

}
