package com.st809.interview.questions.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxDepthTest {

    @Test
    public void single() {
        TreeNode root = new TreeNode(10);
        assertEquals(1, MaxDepth.maxDepth(root));
    }


    @Test
    public void balanced() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        assertEquals(2, MaxDepth.maxDepth(root));
    }

    @Test
    public void unbalanced() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        assertEquals(3, MaxDepth.maxDepth(root));
    }

    @Test
    public void nullRoot() {
        assertEquals(0, MaxDepth.maxDepth(null));
    }
}
