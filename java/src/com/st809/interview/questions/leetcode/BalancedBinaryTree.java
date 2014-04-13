package com.st809.interview.questions.leetcode;

/**
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem a height balanced bianry tree is defined as a binary tree in which the depth of the two subtrees of every node never differ
 * by more than one.
 */
public class BalancedBinaryTree {

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return !(leftHeight < 0 || rightHeight < 0 || Math.abs(leftHeight - rightHeight) > 1);

    }

    /**
     *
     * @param node
     * @return height of the tree or -1 if any subheights had a difference of more than 1
     */
    public static int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        if (leftHeight < 0 || rightHeight < 0 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
