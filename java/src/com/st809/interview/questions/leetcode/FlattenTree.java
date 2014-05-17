package com.st809.interview.questions.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 * <p/>
 * For example,
 * Given
 * <p/>
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * The flattened tree should look like:
 * 1
 * \
 *  2
 *   \
 *   3
 *    \
 *    4
 *     \
 *     5
 *      \
 *      6
 */
public class FlattenTree {
    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        TreeNode parent = null;

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (parent != null) {
                parent.right = node;
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            node.left = null;
            parent = node;
        }
    }
}