package com.st809.interview.questions.leetcode;

import java.util.ArrayList;

/**
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * <p/>
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 * <p/>
 * 1         3     3      2       1
 *  \       /     /      / \      \
 *   3     2     1      1  3      2
 *  /     /       \                \
 * 2     1         2               3
 */
public class UniqueBSTII {

    public static ArrayList<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    private static ArrayList<TreeNode> generateTrees(int start, int end) {
        ArrayList<TreeNode> trees = new ArrayList<>();
        if (start > end) {
            trees.add(null);
            return trees;
        }

        for (int i = start; i <= end; i++) {
            for (TreeNode left : generateTrees(start, i - 1)) {
                for (TreeNode right : generateTrees(i + 1, end)) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    trees.add(root);
                }
            }
        }
        return trees;
    }
}
