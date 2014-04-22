package com.st809.interview.questions.leetcode;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * <p/>
 * If the last word does not exist, return 0.
 * <p/>
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * <p/>
 * For example,
 * Given s = "Hello World",
 * return 5.
 */
public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        int index = s.length() - 1;
        int length = 0;
        while (index >= 0) {
            if (Character.isSpaceChar(s.charAt(index)) && length > 0) {
                return length;
            }
            if (Character.isLetter(s.charAt(index))) {
                length++;
            }
            index--;
        }
        return length;
    }
}
