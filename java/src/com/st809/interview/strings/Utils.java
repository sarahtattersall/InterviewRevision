package com.st809.interview.strings;

import java.util.HashMap;
import java.util.Map;

public class Utils {

    private Utils() {}

    public static Map<Character, Integer> count(Alphabet alphabet, String s) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : alphabet.charSet()) {
            counts.put(c, 0);
        }

        for (char c : s.toCharArray()) {
            if (alphabet.contains(c)) {
                counts.put(c, counts.get(c) + 1);
            }
        }
        return counts;
    }

}
