package com.st809.interview.questions.leetcode;

import com.st809.interview.datastructures.list.LinkedList;
import org.junit.Test;

public class SwapNodesTest {
    @Test
    public void singleNode() {
        ListNode node = new ListNode(1);
        SwapNodes.swapPairs(node);
        Utils.verifyLinkedListSameAsExpected(node, new int[]{1});
    }


    @Test
    public void doubleNode() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        SwapNodes.swapPairs(node);
        Utils.verifyLinkedListSameAsExpected(node, new int[]{2,1});
    }


    @Test
    public void tripleNode() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        SwapNodes.swapPairs(node);
        Utils.verifyLinkedListSameAsExpected(node, new int[]{2,1,3});
    }



    @Test
    public void fourNodes() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        SwapNodes.swapPairs(node);
        Utils.verifyLinkedListSameAsExpected(node, new int[]{2,1,4,3});
    }



}
