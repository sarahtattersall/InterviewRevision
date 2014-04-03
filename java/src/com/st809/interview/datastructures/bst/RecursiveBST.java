package com.st809.interview.datastructures.bst;


import java.util.ArrayDeque;
import java.util.Queue;

public class RecursiveBST<Key extends Comparable<Key>, Value> implements BST<Key,Value> {

    private BSTNode<Key, Value> root;

    public Value getSmallest() {
        return min(root).value;
    }

    public Value getLargest() {
        BSTNode<Key, Value> node = root;
        while (node.right != null) {
            node = node.right;
        }
        return node.value;
    }

    public int size() {
        return size(root);
    }

    private int size(BSTNode<Key, Value> node) {
        if (node == null) {
            return 0;
        }
        return node.N;
    }

    @Override
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(BSTNode<Key, Value> node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return get(node.left, key);
        }
        if (cmp > 0) {
            return get(node.right, key);
        } else {
            return node.value;
        }
    }

    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private BSTNode<Key, Value> put(BSTNode<Key, Value> node, Key key, Value value) {
        if (node == null) {
            return new BSTNode<Key, Value>(key, value, 1);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }

        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    @Override
    public void delete(Key key) {
        root = delete(root, key);
    }

    private BSTNode<Key, Value> delete(BSTNode<Key, Value> node, Key key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.right == null) {
                return node.left;
            }
            if (node.left == null) {
                return node.right;
            }
            BSTNode<Key, Value> tmp = node;
            node = min(tmp.right);
            node.right = deleteMin(tmp.right);
            node.left = tmp.left;

        }
        node.N = size(node.left) + size(node.right) + 1;
        return node;

    }

    public Key min() {
        return min(root).key;
    }

    private BSTNode<Key, Value> min(BSTNode<Key, Value> node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    private BSTNode<Key, Value> deleteMin(BSTNode<Key, Value> node) {
        if (node.left == null) {
            return node.right;
        }

        node.left = deleteMin(node.left);
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, BSTNode<Key, Value> x) {
        if (x == null) {
            return 0;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return rank(key, x.left);
        } else if (cmp > 0) {
            return 1 + size(x.left) + rank(key, x.right);
        } else {
            return size(x.left);
        }

    }

    @Override
    public void inOrder(NodeVisitor<Key, Value> visitor) {
        inOrder(root, visitor);
    }

    private void inOrder(BSTNode<Key, Value> node, NodeVisitor<Key, Value> visitor) {
        if (node == null) {
            return;
        }
        inOrder(node.left, visitor);
        visitor.visit(node);
        inOrder(node.right, visitor);
    }

    @Override
    public void preOrder(NodeVisitor<Key, Value> visitor) {
        preOrder(root, visitor);
    }

    @Override
    public void postOrder(NodeVisitor<Key, Value> visitor) {
        postOrder(root, visitor);
    }

    private void preOrder(BSTNode<Key, Value> node, NodeVisitor<Key, Value> visitor) {
        if (node == null) {
            return;
        }
        visitor.visit(node);
        preOrder(node.left, visitor);
        preOrder(node.right, visitor);
    }

    private void postOrder(BSTNode<Key, Value> node, NodeVisitor<Key, Value> visitor) {
        if (node == null) {
            return;
        }
        postOrder(node.left, visitor);
        postOrder(node.right, visitor);
        visitor.visit(node);
    }

    public Iterable<Key> range(Key low, Key high) {
        Queue<Key> queue = new ArrayDeque<Key>();
        range(root, queue, low, high);
        return queue;
    }

    private void range(BSTNode<Key, Value> node, Queue<Key> queue, Key low, Key high) {
        if (node == null) {
            return;
        }
        int cmpLow = low.compareTo(node.key);
        int cmpHigh = high.compareTo(node.key);
        if (cmpLow < 0) {
            range(node.left, queue, low, high);
        }
        if (cmpLow <= 0 && cmpHigh >= 0) {
            queue.add(node.key);
        }
        if (cmpHigh >  0) {
            range(node.right, queue, low, high);
        }

    }
}
