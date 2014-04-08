package com.st809.interview.questions;

import java.util.Arrays;
import java.util.Comparator;


/**
 * You have a certain amount of money to give out as a bonus to employees. The trouble
 * is, who do oyu pick to receive what bonus? You decide to assign a number of points to each
 * employee , which correspond to how much they helped the company last year. You are given
 * an int[] points, where each emelen contains the points earned by the corresponding employee.
 * Using this you are to calculate the bonuses as follows:
 * - First, add up all the points, this is the pool of total points awarded,
 * - Each employee gets a percentage opf the bonus money, equal to the percentage of the point pool
 * that the employee got
 * - Employees can only receive whole percentage amounts, so if an employee's cut of the bonus has a fractional
 * percentage, truncate it
 * - there may be some percentage of bunus left over (because of the truncation). If n% of the bonus is left
 * over, give the top n employees 1% of this. There will be no more bonus left over after
 * this. If two or more employees with the same number of points quality for this "extra" bonus but
 * not enough is left to give them all an extra 1% then give it to the employees that
 * come first in points.
 *
 * The return value is an int[], one element per employee in the order they were passed in.
 * Each element is the percent of the bonus that the employee gets.
 */
public class Bonuses {


    public static int[] getDivision(int[] points) {
        int totalPoints = totalPoints(points);
        return getPercentagePoints(points, totalPoints);
    }

    private static int[] getPercentagePoints(final int[] points, int totalPoints) {
        int[] percentagePoints = new int[points.length];
        int percentageLeft = 100;
        Integer[] topEmployees = new Integer[points.length];
        for (int employee = 0; employee < points.length; employee++) {
            int percentage = (int) Math.floor((points[employee] / (double) totalPoints) * 100);
            percentagePoints[employee] = percentage;
            percentageLeft -= percentage;

            topEmployees[employee] = employee;
        }

        if (percentageLeft > 0) {
            Arrays.sort(topEmployees, new Comparator<Integer>() {

                @Override
                public int compare(Integer o1, Integer o2) {
                    return Integer.compare(points[o2], points[o1]);
                }
            });
            int employee = 0;
            while (percentageLeft > 0) {
                percentagePoints[topEmployees[employee]] += 1;
                employee++;
                percentageLeft--;
            }
        }

        return percentagePoints;
    }

    private static int totalPoints(int[] points) {
        int totalPoints = 0;
        for (int p : points) {
            totalPoints += p;
        }
        return totalPoints;
    }

    public static void main(String[] args) {
        printPoints(getDivision(new int[]{1, 2, 3, 4, 5}));
        printPoints(getDivision(new int[]{5, 5, 5, 5, 5, 5}));
        printPoints(getDivision(
                new int[]{485, 324, 263, 143, 470, 292, 304, 188, 100, 254, 296, 255, 360, 231, 311, 275, 93, 463, 155,
                        266, 197, 140}));

    }

    public static void printPoints(int[] points) {
        System.out.print("{ ");
        for (int p : points) {
            System.out.print(+p + ", ");
        }
        System.out.println("}");
    }
}
