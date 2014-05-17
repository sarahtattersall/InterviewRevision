package com.st809.interview.questions.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemoveNthNodeTest {
    private ListNode head;

    @Before
    public void setUp() {
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
    }

    @Test
    public void middle() {

        ListNode result = RemoveNthNode.removeNthFromEnd(head, 2);
        assertEquals(1, result.val);
        assertEquals(2, result.next.val);
        assertEquals(3, result.next.next.val);
        assertEquals(5, result.next.next.next.val);
    }

    @Test
    public void head() {
        ListNode result =  RemoveNthNode.removeNthFromEnd(head, 5);
        assertEquals(2, result.val);
        assertEquals(3, result.next.val);
        assertEquals(4, result.next.next.val);
        assertEquals(5, result.next.next.next.val);
    }

    @Test
    public void end() {
        ListNode result =  RemoveNthNode.removeNthFromEnd(head, 1);
        assertEquals(1, result.val);
        assertEquals(2, result.next.val);
        assertEquals(3, result.next.next.val);
        assertEquals(4, result.next.next.next.val);
    }
}
