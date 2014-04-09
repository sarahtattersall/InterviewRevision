package com.st809.interview.questions.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class BinaryTreeInOrder {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ordering = new ArrayList<>();
        if (root == null) {
            return ordering;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                ordering.add(node.val);
                node = node.right;
            }
        }
        return ordering;
    }

}
