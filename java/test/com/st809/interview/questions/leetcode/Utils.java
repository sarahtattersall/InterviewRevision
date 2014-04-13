package com.st809.interview.questions.leetcode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class Utils {
    private Utils() {

    }


    public static void assertLinkedListOrder(ListNode head, int[] expected) {
        ListNode node = head;
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], node.val);
            node = node.next;
        }
        assertNull(node);
    }

    public static void verifyLinkedListSameAsExpected(ListNode head, int[] expected) {
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
