package com.st809.interview.questions;

import java.math.BigInteger;

/**
 * A new startport has just started working. Starting from some moment of time
 * call it minute 0, a new space ship arrives at the startport every M minutes.
 * Similarly starting from minute 0 and repeating each N minutes, all arrived spaceships
 * that are still placed at the port are teleported to the shed. If a spaceship arrives at the exact smae minute
 * when such a teleporatation happens it is immediate.
 *
 * Let the wating time be the time between arrival and teleportation. return average waiting time in minutes
 *
 * Note:
 * for getExpectedTime(4, 2) = 2;
 *     getExpectedTime(5, 3) = 2.5;
 *     getExpectedTime(12345, 2345) = 6170.0
 */
public class Starship {

    public static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        return gcd(q, p % q);
    }

    public static double getExpectedTime(int N, int M) {
//        int countedArrivals = 0;
//        int nextArrival = N;
//
//        double w = 0;
//        for (int arrival = M; arrival <= N * M; arrival += M) {
//            while (arrival > nextArrival) {
//                nextArrival += N;
//            }
//
//            w += nextArrival - arrival;
//            countedArrivals++;
//        }
//        return w/countedArrivals;
        int gcd = gcd(N, M);
        return gcd*(N/(gcd) -1)/2.0;
    }

    public static void main(String[] arrival) {
        System.out.println(gcd(12345,2345));
        System.out.println(getExpectedTime(4, 2));
        System.out.println(getExpectedTime(5, 3));
        System.out.println(getExpectedTime(6, 1));
        System.out.println(getExpectedTime(999999999, 1000000000));
        System.out.println(getExpectedTime(12345, 2345));
    }
}
