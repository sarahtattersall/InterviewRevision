package com.st809.interview.questions.leetcode;

/**
 * Given a sorted linked list delete all duplicates such that each element appears only once
 *
 * For example:
 * 1->1->2 return 1->2
 * 1->1->2->3->3 return 1->2->3
 */
public class RemoveDuplicates {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while(node != null) {
            ListNode next = node.next;
            while(next != null && node.val == next.val) {
                node.next = next.next;
                next = next.next;
            }
            node = node.next;
        }
        return head;
    }

    /**
     * Avoids second while but does the exact same thing!
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicatesPrevious(ListNode head) {
        ListNode node = head;
        while(node != null && node.next != null) {
            if(node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }
}
