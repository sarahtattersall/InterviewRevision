package com.st809.interview.questions.leetcode;

public class CountAndSay {

    public static String countAndSay(int n) {
        if (n == 0) {
            return "";
        }
        String previous = "1";
        if (n == 1) {
            return previous;
        }

        StringBuilder sequence = new StringBuilder();
        for (int i = 1; i < n; i++) {
            sequence.setLength(0); // clear
            int count = 1;
            char value = previous.charAt(0);
            for (int index = 1; index < previous.length(); index++) {
                if (previous.charAt(index) == value) {
                    count++;
                } else {
                    sequence.append(count).append(value);
                    count = 1;
                    value = previous.charAt(index);
                }
            }
            sequence.append(count).append(value);
            previous = sequence.toString();
        }

        return sequence.toString();

    }

    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            System.out.println(String.format("%d : %s", i, countAndSay(i)));
        }
    }
}
