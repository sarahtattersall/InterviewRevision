package com.st809.interview.questions.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PopulateRightPointerTest {
    @Test
    public void singleNode() {
        TreeLinkNode root = new TreeLinkNode();
        PopulateRightPointer.connect(root);
        assertNull(root.next);
    }

    @Test
    public void twoLevels() {
        TreeLinkNode root = new TreeLinkNode();
        TreeLinkNode left = new TreeLinkNode();
        TreeLinkNode right = new TreeLinkNode();
        root.left = left;
        root.right = right;

        PopulateRightPointer.connect(root);
        assertNull(root.next);
        assertEquals(left.next, right);
        assertNull(right.next);
    }

    @Test
    public void threeLevels() {
        TreeLinkNode one = new TreeLinkNode();
        TreeLinkNode two = new TreeLinkNode();
        TreeLinkNode three = new TreeLinkNode();
        TreeLinkNode four = new TreeLinkNode();
        TreeLinkNode five = new TreeLinkNode();
        TreeLinkNode six = new TreeLinkNode();
        TreeLinkNode seven = new TreeLinkNode();

        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        three.left = six;
        three.right = seven;

        PopulateRightPointer.connect(one);

        assertNull(one.next);
        assertEquals(two.next, three);
        assertNull(three.next);
        assertEquals(four.next, five);
        assertEquals(five.next, six);
        assertEquals(six.next, seven);
        assertNull(seven.next);

    }
}
