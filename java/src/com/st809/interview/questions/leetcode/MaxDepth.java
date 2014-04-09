package com.st809.interview.questions.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxDepth {

    public static int maxDepthRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepthRecursive(root.left);
        int right = maxDepthRecursive(root.right);
        return Math.max(left, right)  + 1;
    }

    public static int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        int maxDepth = 0;
        TreeNode previous = null;
        while(!stack.isEmpty()) {
            TreeNode current = stack.peek();
            if (previous == null || previous.left == current || previous.right == current) {
                if (current.left != null) {
                    stack.push(current.left);
                }
                else if (current.right != null) {
                    stack.push(current.right);
                }
            } else if (current.left == previous) {
                if (current.right != null) {
                    stack.push(current.right);
                }
            } else {
                stack.pop();
            }
            previous = current;
            if (stack.size() > maxDepth) {
                maxDepth = stack.size();
            }
        }

        return maxDepth;
    }

}
