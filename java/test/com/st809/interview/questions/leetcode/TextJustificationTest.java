package com.st809.interview.questions.leetcode;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TextJustificationTest {

    @Test
    public void example() {
        ArrayList<String> result = TextJustification.fullJustify(
                new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
        assertEquals(3, result.size());
        assertEquals("This    is    an", result.get(0));
        assertEquals("example  of text", result.get(1));
        assertEquals("justification.  ", result.get(2));
    }

    @Test
    public void anotherExample() {
        ArrayList<String> result = TextJustification.fullJustify(
                new String[]{"Here","is","an","example","of","text","justification."}, 14);
        assertEquals(4, result.size());
        assertEquals("Here   is   an", result.get(0));
        assertEquals("example     of", result.get(1));
        assertEquals("text          ", result.get(2));
        assertEquals("justification.", result.get(3));
    }

    @Test
    public void failed() {
        ArrayList<String> result = TextJustification.fullJustify(
                new String[]{"a","b","c","d","e"}, 1);
        assertEquals(5, result.size());
        assertEquals("a", result.get(0));
        assertEquals("b", result.get(1));
        assertEquals("c", result.get(2));
        assertEquals("d", result.get(3));
        assertEquals("e", result.get(4));
    }

    @Test
    public void failed2() {
        ArrayList<String> result = TextJustification.fullJustify(
                new String[]{"Listen","to","many,","speak","to","a","few."}, 6);
        assertEquals(6, result.size());
        assertEquals("Listen", result.get(0));
        assertEquals("to    ", result.get(1));
        assertEquals("many, ", result.get(2));
        assertEquals("speak ", result.get(3));
        assertEquals("to   a", result.get(4));
        assertEquals("few.  ", result.get(5));
    }
}
