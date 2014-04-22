package com.st809.interview.questions.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LengthOfLastWordTest {

    @Test
    public void helloWord() {
        assertEquals(5, LengthOfLastWord.lengthOfLastWord("Hello World"));
    }

    @Test
    public void helloWordManySpaces() {
        assertEquals(5, LengthOfLastWord.lengthOfLastWord("Hello    World       "));
    }


    @Test
    public void hello() {
        assertEquals(5, LengthOfLastWord.lengthOfLastWord("Hello"));
    }

    @Test
    public void noWord() {
        assertEquals(0, LengthOfLastWord.lengthOfLastWord(""));
    }
}
