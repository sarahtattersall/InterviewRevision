package com.st809.interview.questions.leetcode;

import com.sun.tools.javac.resources.legacy;

/**
 * Populate each next pointer to point to its next right node. If there is no next right node,
 * the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 * Note:
 * - You may only use constant extra space.
 * - You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 * <p/>
 * For example:
 * Given the following perfect binary tree,
 *      1
 *    /  \
 *   2    3
 *  / \  / \
 * 4  5  6  7
 * <p/>
 * After calling your function, the tree should look like:
 *      1 -> NULL
 *    /  \
 *   2 -> 3 -> NULL
 *  / \  / \
 * 4->5->6->7 -> NULL
 */
public class PopulateRightPointer {

    public static void connectOld(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode left = root.left;
        TreeLinkNode right = root.right;
        while(left != null && right != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }

        connectOld(root.left);
        connectOld(root.right);
    }

    /**
     * A better implementation that makes use of the next as set previously
     * @param root
     */
    public static void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode left = root.left;
        TreeLinkNode right = root.right;
        if (left != null && right != null) {
            left.next = right;
            right.next = (root.next != null) ? root.next.left: null;
        }
        connect(root.left);
        connect(root.right);
    }
}
