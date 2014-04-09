package com.st809.interview.questions.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */
public class SameTree {
    public static boolean isSameTreeRecursive(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        boolean sameData = p.val == q.val;
        boolean left = isSameTreeRecursive(p.left, q.left);
        boolean right = isSameTreeRecursive(p.right, q.right);
        return sameData && left && right;
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        Deque<TreeNode> pStack = new ArrayDeque<>();
        Deque<TreeNode> qStack = new ArrayDeque<>();

        pStack.push(p);
        qStack.push(q);

        while (!pStack.isEmpty() && !qStack.isEmpty()) {
            TreeNode pCurrent = pStack.pop();
            TreeNode qCurrent = qStack.pop();

            if (pCurrent.val != qCurrent.val) {
                return false;
            }

            if (pCurrent.left != null) {
                pStack.push(pCurrent.left);
            }
            if (pCurrent.right != null) {
                pStack.push(pCurrent.right);
            }
            if (qCurrent.left != null) {
                qStack.push(qCurrent.left);
            }
            if (qCurrent.right != null) {
                qStack.push(qCurrent.right);
            }

        }
        return pStack.size() == qStack.size();
    }
}
