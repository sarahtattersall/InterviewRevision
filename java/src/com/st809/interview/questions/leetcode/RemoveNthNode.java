package com.st809.interview.questions.leetcode;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * <p/>
 * For example,
 * <p/>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p/>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 */
public class RemoveNthNode {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        Pair p = auxillary(head, n);
        return p.node;
    }

    public static Pair auxillary(ListNode node, int n) {
        if (node.next == null) {
            if (n == 1) {
                return new Pair(null, 1);
            }
            return new Pair(node, 1);
        }

        Pair p = auxillary(node.next, n);
        if (p.fromEnd == n - 1) {
            return new Pair(node.next, p.fromEnd+1);
        } else {
            node.next = p.node;
            return new Pair(node, p.fromEnd + 1);
        }



    }

    public static class Pair {
        public Pair(ListNode node, int fromEnd) {
            this.node = node;
            this.fromEnd = fromEnd;
        }

        public final ListNode node;
        public final int fromEnd;
    }
}
