package com.st809.interview.questions.leetcode;

import com.st809.interview.datastructures.list.LinkedList;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LinkedListCycleTest {

    @Test
    public void nullNode() {
        assertFalse(LinkedListCycle.hasCycle(null));
    }

    @Test
    public void singleNode() {
        assertFalse(LinkedListCycle.hasCycle(new ListNode(1)));
    }


    @Test
    public void singleNodeLoop() {
        ListNode head = new ListNode(1);
        head.next = head;
        assertTrue(LinkedListCycle.hasCycle(head));
    }

    @Test
    public void twoNodes() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        assertFalse(LinkedListCycle.hasCycle(head));
    }

    @Test
    public void twoNodesCycle() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = head;
        assertTrue(LinkedListCycle.hasCycle(head));
    }
}
