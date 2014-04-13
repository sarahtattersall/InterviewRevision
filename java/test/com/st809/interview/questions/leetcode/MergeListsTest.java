package com.st809.interview.questions.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MergeListsTest {

    @Test
    public void oddEven() {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);

        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(4);

        ListNode result = MergeLists.mergeTwoLists(head1, head2);
        Utils.assertLinkedListOrder(result, new int[]{1, 2, 3, 4});
    }

    @Test
    public void disjointOrder() {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);

        ListNode head2 = new ListNode(3);
        head2.next = new ListNode(4);

        ListNode result = MergeLists.mergeTwoLists(head1, head2);
        Utils.assertLinkedListOrder(result, new int[]{1, 2, 3, 4});
    }

    @Test
    public void oddEvenRecursive() {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);

        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(4);

        ListNode result = MergeLists.mergeTwoListsRecursive(head1, head2);
        Utils.assertLinkedListOrder(result, new int[]{1, 2, 3, 4});
    }

    @Test
    public void disjointOrderRecursive() {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);

        ListNode head2 = new ListNode(3);
        head2.next = new ListNode(4);

        ListNode result = MergeLists.mergeTwoListsRecursive(head1, head2);
        Utils.assertLinkedListOrder(result, new int[]{1, 2, 3, 4});
    }


}
