package com.st809.interview.questions.leetcode;

public class ReverseLinkedList {
    public static ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode current = head;
        ListNode next = null;
        ListNode prev = null;
        ListNode tail = null;
        ListNode start = null;
        for (int i = 1; i <= n; i++) {
            if (i < m) {
                start = current;
            } else if (i == m) {
                tail = current;
            }
            next = current.next;
            if (i >= m) {
                current.next = prev;
            }
            prev = current;
            current = next;
        }
        tail.next = next;
        if (start != null) {
            start.next = prev;
            return head;
        }
        return prev;

    }

}
