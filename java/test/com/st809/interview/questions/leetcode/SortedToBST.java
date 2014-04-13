package com.st809.interview.questions.leetcode;

/**
 * Given an array where elements
 * are sorted in ascending order, convert it to a height balanced BST
 */
public class SortedToBST {
   public static TreeNode sortedArrayToBSTRecursive(int[] num) {
       return recursive(num, 0, num.length - 1);
   }

    public static TreeNode recursive(int[] num, int lo, int hi) {
        if ( lo > hi) {
            return null;
        }

        int middle = (hi + lo)/ 2;

        TreeNode node = new TreeNode(num[middle]);

        node.left = recursive(num, lo, middle -1);
        node.right = recursive(num, middle + 1, hi);

        return node;
    }
}
