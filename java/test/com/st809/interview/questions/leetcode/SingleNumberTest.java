package com.st809.interview.questions.leetcode;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SingleNumberTest {

    @Test
    public void ordered() {
        assertEquals(5, SingleNumber.findSingleNumber(Arrays.asList(1, 1, 2, 2, 4, 4, 5)));
    }


    @Test
    public void unordered() {
        assertEquals(5, SingleNumber.findSingleNumber(Arrays.asList(1,2,1,4,2,4,5)));
    }

    @Test
    public void unorderedAppearsThrice() {
        assertEquals(5, SingleNumber.findSingleNumber(Arrays.asList(1,2,1,4,2,4,5,5,5)));
    }
}
