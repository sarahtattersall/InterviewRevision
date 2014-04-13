package com.st809.interview.questions.leetcode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p/>
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * <p/>
 * Your algorithm should use only constant space.
 * You may not modify the values in the list, only nodes itself can be changed.
 */
public class SwapNodes {
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode second = head.next;
        ListNode third = second.next;
        second.next = head;
        head.next = swapPairs(third);
        return second;
    }

    public static ListNode swapPairsIterative(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pprev = null;
        ListNode prev = head;
        ListNode current = head.next;
        ListNode ret = current;
        while(current != null) {
            ListNode ahead = current.next;
            current.next = prev;
            prev.next = ahead;
            if (pprev != null) {
                pprev.next = current;
            }

            pprev = prev;
            prev = prev.next;
            if (ahead != null) {
                current = ahead.next;
            } else {
                current = null;
            }
        }
        return ret;
    }
}
