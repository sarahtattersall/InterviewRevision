package com.st809.interview.questions.leetcode;

import java.util.ArrayList;

/**
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully
 * (left and right) justified.
 * <p/>
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra
 * spaces ' ' when necessay so that each line has exactly L characters
 * <p/>
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line
 * do not divde evenly between words, the empty slots on the left will be assigned more spaces than slots on the right.
 * <p/>
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 * <p/>
 * Return the formatted lines as:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 */
public class TextJustification {
    public static ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> line = new ArrayList<>();

        int lineLength = 0;
        for (String word : words) {
            if (lineLength + line.size() + word.length() <= L) {
                lineLength += word.length(); // Add one for space after word...
                line.add(word);
            } else {
                int numberOfWords = line.size();
                if (numberOfWords == 1) {
                    result.add(leftJustify(line, lineLength, L));
                } else {
                    result.add(justify(line, lineLength, L));
                }

                line.clear();
                line.add(word);
                lineLength = word.length();
            }
        }
        result.add(leftJustify(line, lineLength, L));

        return result;
    }

    private static String justify(ArrayList<String> line, int lineSize, int totalLineLength) {
        StringBuilder builder = new StringBuilder();
        int numberOfWords = line.size();
        int leftOver = totalLineLength - lineSize;
        int defaultSpaces = leftOver / (numberOfWords - 1);
        int leftOverSpaces = leftOver % (numberOfWords - 1);

        for (int i = 0; i < line.size() - 1; i++) {
            builder.append(line.get(i));
            for (int j = 0; j < defaultSpaces; j++) {
                builder.append(" ");
            }
            if (leftOverSpaces > 0) {
                builder.append(" ");
                leftOverSpaces--;
            }
        }
        builder.append(line.get(line.size() - 1));
        for (int j = 0; j < leftOverSpaces; j++) {
            builder.append(" ");
        }
        return builder.toString();
    }

    /**
     *
     * @param line line of words, no spaces
     * @param lineSize number of chars cocontainn line
     * @param totalLineLength number of chars allowed in line
     * @return
     */
    private static String leftJustify(ArrayList<String> line, int lineSize, int totalLineLength) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < line.size() -1; i++) {
            builder.append(line.get(i)).append(" ");
        }
        builder.append(line.get(line.size() -1));
        for (int i = builder.length(); i < totalLineLength; i++) {
            builder.append(" ");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        ArrayList<String> result = fullJustify( new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
        for (String s : result) {
            System.out.println(s);
        }
    }
}
