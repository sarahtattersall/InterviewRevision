package com.st809.interview.questions.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RemoveDuplicatesTest {

    @Test
    public void testOne() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);

        int[] expected = {1, 2};
        verifyExpected(RemoveDuplicates.deleteDuplicates(node), expected);
    }

    @Test
    public void testTwo() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);

        int[] expected = {1, 2, 3};
        verifyExpected(RemoveDuplicates.deleteDuplicates(node), expected);
    }

    @Test
    public void testThree() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(3);

        int[] expected = {1, 2, 3};
        verifyExpected(RemoveDuplicates.deleteDuplicates(node), expected);
    }

    private void verifyExpected(ListNode head, int[] expected) {
        ListNode node = head;
        int index = 0;
        while (node != null) {

            assertTrue(index < expected.length);
            assertEquals(expected[index], node.val);
            index++;
            node = node.next;
        }

        assertEquals(index, expected.length);
    }
}
