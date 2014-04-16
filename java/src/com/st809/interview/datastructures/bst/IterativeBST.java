package com.st809.interview.datastructures.bst;

import java.util.*;

public class IterativeBST<Key extends Comparable<Key>, Value> implements BST<Key, Value> {
    BSTNode<Key, Value> root;

    @Override
    public Value get(Key key) {
        return null;
    }

    @Override
    public void put(Key key, Value value) {
        BSTNode<Key, Value> node = root;
        BSTNode<Key, Value> newNode = new BSTNode<Key, Value>(key, value, 1);
        if (root == null) {
            root = newNode;
            return;
        }

        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0) {
                if (node.left == null) {
                    node.left = newNode;
                    return;
                }
                node = node.left;
            } else if (cmp > 0) {
                if (node.right == null) {
                    node.right = newNode;
                    return;
                }
                node = node.right;
            } else {
                node.value = value;
                return;
            }
        }
    }

    @Override
    public void delete(Key key) {

    }

    @Override
    public void inOrder(NodeVisitor<Key, Value> visitor) {

        if (root == null) {
            return;
        }
        Deque<BSTNode<Key, Value>> stack = new ArrayDeque<>();
        BSTNode<Key, Value> node = root;
        while(!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                visitor.visit(node);
                node = node.right;
            }

        }

    }

    @Override
    public void preOrder(NodeVisitor<Key, Value> visitor) {
        if (root == null) {
            return;
        }
        Deque<BSTNode<Key, Value>> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            BSTNode<Key, Value> node = stack.pop();
            visitor.visit(node);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    @Override
    public void postOrder(NodeVisitor<Key, Value> visitor) {
        if (root == null) {
            return;
        }
        Deque<BSTNode<Key, Value>> stack = new ArrayDeque<>();
        Set<Node<Key, Value>> seen = new HashSet<>();

        stack.push(root);
        while(!stack.isEmpty()) {
           BSTNode<Key, Value> node = stack.peek();
           if (seen.contains(node)) {
               visitor.visit(node);
               stack.pop();
           } else {
               if (node.right != null) {
                   stack.push(node.right);
               }
               if (node.left != null) {
                   stack.push(node.left);
               }
               seen.add(node);
           }
        }
    }
}
