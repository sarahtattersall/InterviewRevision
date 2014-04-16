package com.st809.interview.datastructures.bst;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * An implementation of a self-balancing red-black tree taken from Introduction
 * to Algorithms by Cormen et al.
 * <p/>
 * A red black tree has the following red-black properties:
 * 1. Every node is either red or black
 * 2. The root is black
 * 3. Every leaf is black (ie null node)
 * 4. If a node is red then both its children are black
 * 5. For each node all simple paths from the node to descendant leaves contain the
 * same number of black nodes.
 */
@SuppressWarnings("SuspiciousNameCombination")
public class RedBlackTree<K extends Comparable<K>, V> implements BST<K, V> {

    private static final RBNodeII.Color RED = RBNodeII.Color.RED;

    private static final RBNodeII.Color BLACK = RBNodeII.Color.BLACK;

    RBNodeII<K, V> root;


    @Override
    public V get(K k) {
        return null;
    }

    /**
     * Inserting a node into a red-black tree happens in O(logn) time.
     * We insert a new node into the tree (like in a BST) and then colour the new node red.
     * To guaranteee the red-black properties are preserved we call auxillary
     * procedure insertFixup to recolour the nodes and perform rotations.
     *
     * @param key
     * @param value
     */
    @Override
    public void put(K key, V value) {
        RBNodeII<K, V> newNode = new RBNodeII<>(key, value);
        RBNodeII<K, V> x = root;
        RBNodeII<K, V> y = null;
        while (x != null) {
            y = x;
            if (key.compareTo(x.key) < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        newNode.parent = y;
        if (y == null) {
            root = newNode;
        } else if (key.compareTo(y.key) < 0) {
            y.left = newNode;
        } else {
            y.right = newNode;
        }

        newNode.color = RED;
        insertFixUp(newNode);
    }

    @Override
    public void delete(K k) {

    }

    @Override
    public void inOrder(NodeVisitor<K, V> visitor) {
        if (root == null) {
            return;
        }
        Deque<RBNodeII<K,V>> stack = new ArrayDeque<>();
//        stack.push(root);
        RBNodeII<K,V> node = root;
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
    public void preOrder(NodeVisitor<K, V> visitor) {
        if (root == null) {
            return;
        }
        Deque<RBNodeII<K,V>> stack = new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            RBNodeII<K, V> node = stack.pop();
            visitor.visit(node);
            if (node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }
        }

    }

    @Override
    public void postOrder(NodeVisitor<K, V> visitor) {

    }

    /**
     * Inserting a node can violate:
     * Property 2 if the new node is the root
     * Property 4 if if the new nodes parent is also red.
     * <p/>
     * The while loop maintains the following three-part invariant at the start of
     * each iteration of the loop:
     * 1. newNode is red
     * 2. If newNode.p is the root, then newNode.p is black
     * 3. If the tree violates any of the red-black properties, then it violates at most one of them
     * and the violation is either property 2 or 4.
     * <p/>
     * In restoring the properties we have three cases to check:
     * Case 1: new node's uncle is red
     * Because x's grandparent is black we can colour both x's and x's uncle
     * black, fixing the problem of the x and its parent being red.
     * We repeat the loop setting x = x.p.p
     * Case 2: x's uncle is black and x is a right child
     * We can use a left rotation to transform the situation into case 3. Since both x and x.p are red
     * this rotation affects neither the black height or property 5.
     * Case 3: x's uncle is black and x is a left child
     * We execute colour changes and a right rotation to preserve property 5 and then since we no
     * longer have two red nodes in a row we are done! :)
     * <p/>
     * Note the while loop only repeats for case 1 and the pointer moves up two levels in the tree
     * This gives a runtime of O(logn)
     *
     * @param x
     */
    private void insertFixUp(RBNodeII<K, V> x) {
        while (x.parent != null && x.parent.color == RED) {
            if (x.parent == x.parent.parent.left) {
                RBNodeII<K, V> uncle = x.parent.parent.right;
                if (uncle != null && uncle.color == RED) {
                    x = insertCaseOne(x, uncle);
                } else {
                    if (x == x.parent.right) {
                        insertCaseTwo(x, Side.LEFT);
                    }
                    insertCaseThree(x, Side.LEFT);
                }
            } else {
                RBNodeII<K, V> uncle = x.parent.parent.left;
                if (uncle != null && uncle.color == RED) {
                    x = insertCaseOne(x, uncle);
                } else {
                    if (x == x.parent.left) {
                        insertCaseTwo(x, Side.RIGHT);
                    }
                    insertCaseThree(x, Side.RIGHT);
                }
            }
        }
        root.color = BLACK;
    }

    /**
     * Performs case 1 of the insertion fix, setting both x and its uncle to be black
     * and x's grandparent to be red
     *
     * @param x
     * @param uncle
     * @return grandparent of x
     */
    private RBNodeII<K, V> insertCaseOne(RBNodeII<K, V> x, RBNodeII<K, V> uncle) {
        x.parent.color = BLACK;
        uncle.color = BLACK;
        x.parent.parent.color = RED;
        return x.parent.parent;
    }

    private void insertCaseTwo(RBNodeII<K, V> x, Side side) {
        x = x.parent;
        if (side.equals(Side.LEFT)) {
            leftRotate(x);
        } else {
            rightRotate(x);
        }
    }

    private void insertCaseThree(RBNodeII<K, V> x, Side side) {
        x.parent.color = BLACK;
        x.parent.parent.color = RED;
        if (side.equals(Side.LEFT)) {
            rightRotate(x.parent.parent);
        } else {
            leftRotate(x.parent.parent);
        }
    }

    /**
     * Performs a right rotation on the specified node by pivoting around the link from the nodes
     * left child and itself. It makes the left child, X, the new root of the subtree and sets
     * Y to be the right child of X and Y's left child to be the X's old right child.
     * I.e.
     *     Y                               X
     *    / \   right rotate around Y     / \
     *   X  c  ====================>     a  Y
     *  / \                                / \
     * a   b                              b  c
     *
     * @param y - node to right rotate. It is assumed that this nodes left child is not null.
     */
    private void rightRotate(RBNodeII<K, V> y) {
        RBNodeII<K, V> x = y.left;
        y.left = x.right;
        if (x.right != null) {
            x.right.parent = y;
        }

        x.parent = y.parent;

        if (y.parent == null) {
            root = x;
        } else if (y == y.parent.left) {
            y.parent.left = x;
        } else {
            y.parent.right = x;
        }
        x.right = y;
        y.parent = x;
    }


    /**
     * Performs a left rotation on the specified node by pivoting around the link from the nodes
     * right child and itself. It makes the right child, Y, the new root of the subtree and sets
     * X to be the left child of Y and X's right child to be the Y's old left child.
     * <p/>
     * I.e.
     * <p/>
     * X                               Y
     * / \    left rotate around X     / \
     * a  Y   ====================>   X   c
     * / \                         / \
     * b   c                       a   b
     *
     * @param x - node to left rotate. It is assumed that this nodes right child is not null.
     */
    private void leftRotate(RBNodeII<K, V> x) {
        RBNodeII<K, V> y = x.right;
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }

        y.parent = x.parent;

        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }



    private static enum Side {
        LEFT, RIGHT
    }


    public static void main(String args[]) {
        RedBlackTree<Integer, Integer> tree = new RedBlackTree<>();
        for (int i = 0; i < 10; i++) {
            tree.put(i, i);
        }

        tree.preOrder(new NodePrinter<Integer, Integer>());
    }
}
