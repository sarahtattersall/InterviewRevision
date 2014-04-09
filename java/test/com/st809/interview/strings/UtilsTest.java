package com.st809.interview.strings;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class UtilsTest {
    @Test
    public void count() {
        Alphabet alphabet = new Alphabet("ABCDR");
        Map<Character, Integer> actualCounts = Utils.count(alphabet, "ABRACADABRA!");
        assertEquals(5, actualCounts.size());
        assertEquals(5, actualCounts.get('A').intValue());
        assertEquals(2, actualCounts.get('B').intValue());
        assertEquals(1, actualCounts.get('C').intValue());
        assertEquals(1, actualCounts.get('D').intValue());
        assertEquals(2, actualCounts.get('R').intValue());
    }

}
