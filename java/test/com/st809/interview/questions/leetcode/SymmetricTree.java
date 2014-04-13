package com.st809.interview.questions.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * <p/>
 * For example, this binary tree is symmetric:
 * <p/>
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * But the following is not:
 *    1
 *   / \
 *  2   2
 *  \   \
 *  3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 */
public class SymmetricTree {
    public static boolean isSymmetricRecursive(TreeNode root) {
        if (root == null) {
            return true;
        }
        return symmetric(root.left, root.right);
    }

    public static boolean symmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }

        return symmetric(left.left, right.right) && symmetric(left.right, right.left);
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root.left);
        queue.add(root.right);

        while(!queue.isEmpty()) {
            TreeNode left = queue.pop();
            if (queue.isEmpty()) { //Must come in pairs!
                return false;
            }
            TreeNode right = queue.pop();
            if (left.val != right.val) {
                return false;
            }

            if (left.left != null && right.right != null) {
                queue.add(left.left);
                queue.add(right.right);
            }

            if (left.right != null && right.left != null) {
                queue.add(left.right);
                queue.add(right.left);
            }

            if ((left.left == null && right.right != null) ||
                (left.left != null && right.right == null) ||
                (left.right == null && right.left != null) ||
                (left.right != null && right.left == null)) {
                return false;
            }
        }
        return true;
    }
}
