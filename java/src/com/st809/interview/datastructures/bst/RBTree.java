package com.st809.interview.datastructures.bst;

public class RBTree<Key extends Comparable<Key>, Value> implements BST<Key, Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private RBNode<Key, Value> root;

    @Override
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(RBNode<Key, Value> node, Key key) {
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

    private RBNode<Key, Value> put(RBNode<Key, Value> node, Key key, Value value) {
        if (node == null) {
            return new RBNode<Key, Value>(key, value, 1, RED);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }

        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    @Override
    public void delete(Key key) {

    }

    @Override
    public void inOrder(NodeVisitor<Key, Value> visitor) {

    }

    @Override
    public void preOrder(NodeVisitor<Key, Value> visitor) {

    }

    @Override
    public void postOrder(NodeVisitor<Key, Value> visitor) {

    }

    private boolean isRed(RBNode<Key, Value> node)
    {
        return node != null && node.color == RED;
    }

    /**
     * Rotates a red link from:
     *      E
     *     / |<---- red
     *        S
     *
     * into      S
     *  red --> / |
     *         E
     * @param node old parent node E
     * @return parent node S
     */
    private RBNode<Key, Value> rotateLeft(RBNode<Key, Value> node) {
        RBNode<Key, Value> larger = node.right;
        node.right = larger.left;
        larger.left = node;
        larger.color = node.color;
        node.color = RED;
        larger.N = node.N;
        node.N = 1 + size(node.left) + size(node.right);
        return larger;


    }

    /**
     * Rotates a red link from:
     *           S
     * red -->  / |
     *         E
     *
     * into      E
     *          / | <---- red
     *         S
     * @param node old parent node S
     * @return parent node E
     */
    private RBNode<Key, Value> rotateRight(RBNode<Key, Value> node) {
        RBNode<Key, Value> smaller = node.left;
        node.left = smaller.right;
        smaller.right = node;
        smaller.color = node.color;
        node.color = RED;
        smaller.N = node.N;
        node.N = 1 + size(node.left) + size(node.right);
        return smaller;
    }

    public int size() {
        return size(root);
    }

    private int size(RBNode<Key, Value> node) {
        if (node == null) {
            return 0;
        }
        return node.N;
    }

    /**
     * Changes the node to be red and its children to be black
     * @param node original parent node
     */
    private void flipColors(RBNode<Key, Value> node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }
}
