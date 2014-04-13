package com.st809.interview.questions.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinDepthTest {

    @Test
    public void depthZeroForNull() {
        assertEquals(0, MinDepth.minDepth(null));
    }

    @Test
    public void depthOneForSingleNode() {
        assertEquals(1, MinDepth.minDepth(new TreeNode(1)));
    }


    @Test
    public void depthTwo() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        assertEquals(2, MinDepth.minDepth(root));
    }

    @Test
    public void depthOne() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(2);
        assertEquals(2, MinDepth.minDepth(root));
    }

    @Test
    public void leftTail() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.left.left = new TreeNode(5);
        assertEquals(5, MinDepth.minDepth(root));
    }
}
