package com.st809.interview.questions.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a binary tree, find its minimum depth.
 * <p/>
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class MinDepth {

    public static int minDepthRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.min(minDepthRecursive(root.left), minDepthRecursive(root.right)) + 1;
    }

    /**
     * The trick here is realising that in a postorder traversal the stack size is the depth
     * @param root
     * @return
     */
    public static int minDepthDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        TreeNode previous = null;
        int minDepth = Integer.MAX_VALUE;
        while(!stack.isEmpty()) {
            TreeNode current = stack.peek();
            if (previous == null || previous.left == current || previous.right == current) {
                if (current.left != null) {
                    stack.push(current.left);
                } else if (current.right != null) {
                    stack.push(current.right);
                } else {
                    if (stack.size() < minDepth) { //At bottom node
                        minDepth = stack.size();
                    }
                }
            } else if (current.left == previous && current.right != null) {
                stack.push(current.right);
            } else {
                stack.pop();
            }
            previous = current;
        }
        return minDepth;
    }

    /**
     * Uses BFS and stops when it finds the first node
     * Keeps track of the depth with a variable elemsToDecrease
     */
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        int currentDepth = 1;
        int elemsToDecrease = 1; // The number of elements on the current level left to process
        int nextToDecrease = 0; // The number of elements added in the next level

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            elemsToDecrease--;
            int childCount = numberOfChildren(current);

            if (childCount == 0) {
                return currentDepth;
            }

            if (current.left != null) {
                queue.add(current.left);
                nextToDecrease++;
            } if (current.right != null) {
                queue.add(current.right);
                nextToDecrease++;
            }

            if (elemsToDecrease == 0) { // Last node at this depth
                currentDepth++;
                elemsToDecrease = nextToDecrease;
                nextToDecrease = 0;
            }

        }
        return currentDepth;
    }

    private static int numberOfChildren(TreeNode node) {
        if (node.left == null && node.right == null) {
            return 0;
        } if (node.left == null || node.right == null) {
            return 1;
        }
        return 2;

    }
}
