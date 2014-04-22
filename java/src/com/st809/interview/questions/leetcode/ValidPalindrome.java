package com.st809.interview.questions.leetcode;

public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char leftVal = Character.toLowerCase(s.charAt(left));
            char rightVal = Character.toLowerCase(s.charAt(right));


            if (!Character.isLetterOrDigit(leftVal)) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(rightVal)) {
                right--;
                continue;
            }
            if (leftVal != rightVal) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
