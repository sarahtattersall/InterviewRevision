package com.st809.interview.questions.leetcode;


import java.util.*;

/**
 * Two elements of a bianry search tree have been swapped by mistake
 * Recover the tree without changing its structure
 * <p/>
 * Note:
 * A solution using O(n) space is pretty straight forward could you devise a constant space solution instead?
 */
public class RecoverTree {
    public static void recoverTreeOld(TreeNode root) {
        List<TreeNode> suspicious = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            TreeNode left = node.left;
            if (left != null) {
                if (left.val > node.val) {
                    suspicious.add(left);
                }
                queue.add(left);
            }
            TreeNode right = node.right;
            if (right != null) {
                if (right.val < node.val) {
                    suspicious.add(right);
                }
                queue.add(right);
            }
        }

        if (suspicious.size() == 1) {
            suspicious.add(root);
        }

        int tmp = suspicious.get(0).val;
        suspicious.get(0).val = suspicious.get(1).val;
        suspicious.get(1).val = tmp;

    }

    ArrayList<TreeNode> t;
    TreeNode previous;
    public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        t = new ArrayList<TreeNode>();
        previous=null;
        inorder(root);
        int temp = t.get(0).val;
        t.get(0).val = t.get(t.size()-1).val;
        t.get(t.size()-1).val = temp;
    }
    public void inorder(TreeNode node) {
        if(node==null) return;
        inorder(node.left);
        if(previous!=null&&previous.val>node.val) {
            if(!t.contains(previous)) t.add(previous);
            if(!t.contains(node)) t.add(node);
        }
        previous = node;
        inorder(node.right);
    }

    public static void main(String [] args) {
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(1);
        RecoverTree tree = new RecoverTree();
        tree.recoverTree(root);
    }
}
