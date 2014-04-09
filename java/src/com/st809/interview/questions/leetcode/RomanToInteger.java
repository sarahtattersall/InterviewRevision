package com.st809.interview.questions.leetcode;

/**
 * Given a roman numeral convert it to an integer
 * <p/>
 * Input is guaranteed to be within the range from 1 to 3999
 */
public class RomanToInteger {
    public static int romanToInt(String s) {
        int sum = value(s.charAt(s.length() - 1));
        for (int index = s.length() - 2; index >= 0 ; index--) {
            char i = s.charAt(index);
            int val = value(i);
            if (value(s.charAt(index + 1)) > val) {
                sum -= val;
            } else {
                sum += val;
            }
        }

        return sum;

    }

    private static int value(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                throw new RuntimeException("No such numeral");
        }
    }
}
