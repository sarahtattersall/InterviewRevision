package com.st809.interview.questions.leetcode;

/**
 * Merge two sorted lists and return it as a new List. The new list should be made by splicing together the
 * nodes of the first two lists
 */
public class MergeLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode h1 = l1;
        ListNode h2 = l2;
        ListNode prev;
        if (l1.val < l2.val) {
            prev = l1;
            h1 = h1.next;
        } else {
            prev = l2;
            h2 = h2.next;
        }

        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                prev.next = h1;
                h1 = h1.next;
            } else {
                prev.next = h2;
                h2 = h2.next;
            }
            prev = prev.next;
        }

        if (h1 != null) {
            prev.next = h1;
        } else {
            prev.next = h2;
        }

        return l1.val < l2.val ? l1 : l2;
    }

    public static ListNode mergeTwoListsRecursive(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode ret;
        if (l1.val < l2.val) {
            ret = l1;
            ret.next = mergeTwoListsRecursive(l1.next, l2);

        } else {
            ret = l2;
            ret.next = mergeTwoListsRecursive(l1, l2.next);
        }
        return ret;
    }

}
