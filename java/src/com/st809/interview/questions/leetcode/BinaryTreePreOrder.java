package com.st809.interview.questions.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class BinaryTreePreOrder {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> ordering = new ArrayList<>();
        if (root == null) {
            return ordering;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ordering.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return ordering;
    }
}
