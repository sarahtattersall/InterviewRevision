package com.st809.interview.questions.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a linked list determine if it has a cycle in
 *
 * Follow up:
 * Can you solve it without using extra space
 */
public class LinkedListCycle {

    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        Set<ListNode> seen = new HashSet<>();
        ListNode node  = head;
        while (node != null) {
            if (seen.contains(node)) {
                return true;
            }
            seen.add(node);
            node = node.next;
        }
        return false;
    }

    /**
     * Makes use of Floyd's cycle-finding algorithm (a.k.a Tortoise and hare)
     *
     * Have two references to the list and move them at different speeds.
     * @param head
     * @return
     */
    public static boolean hasCycleNoExtraSpace(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow;
        ListNode fast;
        slow = fast = head;

        while(true) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return false;
            }

            if (slow == null || fast == null) {
                return false;
            }

            if (slow == fast) {
                return true;
            }
        }
    }
}

