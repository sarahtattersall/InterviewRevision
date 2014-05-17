package com.st809.interview.questions.leetcode;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int shortestLength = Integer.MAX_VALUE;
        for (String s : strs) {
            if (s.length() < shortestLength) {
                shortestLength = s.length();
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < shortestLength; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                String str = strs[j];
                if (str.charAt(i) != c) {
                    return builder.toString();
                }
            }
            builder.append(c);
        }
        return builder.toString();

    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"ham", "he", "hi"}));
        System.out.println(longestCommonPrefix(new String[]{"ham"}));
        System.out.println(longestCommonPrefix(new String[]{""}));
        System.out.println(longestCommonPrefix(new String[]{"sarah", "sarat", "saram"}));
    }
}
