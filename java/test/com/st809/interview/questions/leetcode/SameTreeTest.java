package com.st809.interview.questions.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SameTreeTest {

    @Test
    public void sameTreeNull() {
        assertTrue(SameTree.isSameTree(null, null));
    }

    @Test
    public void sameTreeSingle() {
        assertTrue(SameTree.isSameTree(new TreeNode(6), new TreeNode(6)));
    }

    @Test
    public void sameTreeBalanced() {
        TreeNode p = new TreeNode(10);
        p.left = new TreeNode(2);
        p.right = new TreeNode(5);


        TreeNode q = new TreeNode(10);
        q.left = new TreeNode(2);
        q.right = new TreeNode(5);

        assertTrue(SameTree.isSameTree(p, q));
    }

    @Test
    public void notSameTreeBalanced() {

        TreeNode p = new TreeNode(10);
        p.left = new TreeNode(2);
        p.right = new TreeNode(5);


        TreeNode q = new TreeNode(10);
        q.left = new TreeNode(2);
        q.right = new TreeNode(4);
        assertFalse(SameTree.isSameTree(p, q));
    }

    @Test
    public void notSameTreeNull() {

        TreeNode p = new TreeNode(10);
        p.left = new TreeNode(2);
        p.right = new TreeNode(5);

        assertFalse(SameTree.isSameTree(p, null));
    }

    @Test
    public void notSameExtraNode() {
        TreeNode p = new TreeNode(10);
        p.left = new TreeNode(2);
        p.right = new TreeNode(5);


        TreeNode q = new TreeNode(10);
        q.left = new TreeNode(2);
        q.right = new TreeNode(5);
        q.right.right = new TreeNode(6);

        assertFalse(SameTree.isSameTree(p, q));
    }

}
