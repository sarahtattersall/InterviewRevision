package com.st809.interview.strings;

/**
 * Sorts an array of strings that each have exactly W characters
 * Does W key indexed counting sorts.
 */
public class LSD {
    public static void sort(String[] a, int W) {
        int N = a.length;
        int R = 256; //ASCII characters
        String[] aux = new String[N];

        for (int d = W - 1; d >= 0; d--) {
            int[] count = new int[R+1]; //Frequency counts of each char
            for (String str : a) {
                count[str.charAt(d) + 1]++;
            }

            for (int r = 0; r < R; r++) { //Transform to indicies;
                count[r+1] += count[r];
            }

            for (String str : a) {
                aux[count[str.charAt(d)]++] = str;
            }

            System.arraycopy(aux, 0, a, 0, N);
        }
    }

    public static void main(String[] args) {
        String[] a = {"abdc", "barc", "cabh", "sara", "fehs", "zzzz", "aaaa"};
        LSD.sort(a, 4);

        System.out.println("SORTED:");
        System.out.print("{");
        for (String str : a) {
            System.out.print(str + ", ");
        }
        System.out.println("}");

    }
}
