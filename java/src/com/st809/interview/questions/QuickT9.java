package com.st809.interview.questions;

public class QuickT9 {

    public static void minimumPressings(String[] dictionary, String word) {
        // Current combination of digits
        String D = "";

        // Fixed part of the message
        String F = "";

        // Unfixed part of the message
        String U = "";


    }

    private static char charToKey(char c) {
        switch (c) {
            case 'a' :case 'b' :case 'c':
                return '2';
            case 'd' :case 'e' :case 'f':
                return '3';
            case 'g':case 'h':case 'i':
                return '4';
            case 'j':case 'k':case 'l':
                return '5';
            case 'm':case 'n':case 'o':
                return '6';
            case 'p':case 'q':case 'r':case 's':
                return '7';
            case 't':case 'u':case 'v':
                return '8';
            case 'w':case'x':case 'y':case'z':
                return '9';
            default:
                throw new RuntimeException("Not a valid key");
        }
    }
}
