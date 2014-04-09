package com.st809.interview.strings;

import java.util.HashMap;
import java.util.Map;

public class Alphabet {

    private String alphabet;
    private Map<Character, Integer> indicies = new HashMap<>();

    /**
     * A new alphabet made up of chars in alphabet
     * @param alphabet
     */
    public Alphabet(String alphabet) {
        this.alphabet = alphabet;
        int index = 0;
        for (char c : alphabet.toCharArray()) {
            indicies.put(c, index);
            index++;
        }
    }

    /**
     * Convert index into char
     * @param index
     * @return char at index;
     */
    public char toChar(int index) {
        return alphabet.charAt(index);
    }

    int toIndex(char c) {
        return indicies.get(c);
    }

    /**
     *
     * @param c
     * @return if c is in the alphabet
     */
    boolean contains(char c) {
        return indicies.containsKey(c);
    }

    /**
     *
     * @return radix (number of chars in alphabet)
     */
    int R() {
        return alphabet.length();
    }

    /**
     *
     * @return number of bits to represent an integer
     */
    int lgR() {
        return (int) Math.ceil(Math.log(R()));
    }

    /**
     *
     * @param s
     * @return s in base-R integer representation
     */
    int[] toIndicies(String s) {
        int[] result = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            result[i] = toIndex(s.charAt(i));
        }
        return result;
    }

    public char[] charSet() {
        return alphabet.toCharArray();
    }
}
