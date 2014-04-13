package com.st809.interview.questions.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BalancedBinaryTreeTest {

    @Test
    public void nullIsBalanced() {
        assertTrue(BalancedBinaryTree.isBalanced(null));
    }

    @Test
    public void singeIsBalanced() {
        assertTrue(BalancedBinaryTree.isBalanced(new TreeNode(3)));
    }

    @Test
    public void oneLevelDiffIsBalanced() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        assertTrue(BalancedBinaryTree.isBalanced(root));
    }


    @Test
    public void balancedIsBalanced() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        assertTrue(BalancedBinaryTree.isBalanced(root));
    }

    @Test
    public void twoLevelDiffIsNotBalanced() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        assertFalse(BalancedBinaryTree.isBalanced(root));
    }

    @Test
    public void fourLevelIsNotBalanced() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.right.right.right = new TreeNode(4);
        assertFalse(BalancedBinaryTree.isBalanced(root));
    }
}
