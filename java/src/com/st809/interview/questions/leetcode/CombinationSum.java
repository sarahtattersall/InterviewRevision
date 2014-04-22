package com.st809.interview.questions.leetcode;

import java.util.ArrayList;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where
 * the candidate numbers sum to T.
 *
 * The same repeated number may be chosen from C an unlimited number of times
 *
 * Note:
 * - All elements including the target will be positive integers
 * - Elements in a combination (a1, a2, ..., ak) must be in non-descending order i.e. (a1 <= a2 <=... <=ak)
 * - The solution set must not contain duplicate combinations
 *
 * For example, given candidate set 2, 3, 6, 7
 * A solution set is:
 * [7], [2, 2, 3]
 */
public class CombinationSum {
    public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> r = new ArrayList<>();
        add(candidates, 0, target, new ArrayList<Integer>(), r);
        return  r;

    }

    private static void add(int[] candidates, int start, int target, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> results) {
        if (start < 0 || start >= candidates.length || target < 0) {
            return;
        }

        if (target == 0) {
            ArrayList<Integer> result = new ArrayList<>(path);
            results.add(result);
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (candidates[i] > target) {
                    continue;
                }
                path.add(candidates[i]);
                add(candidates, i, target - candidates[i], path, results);
                path.remove(path.size() -1);
            }
        }

    }

    public static void main(String[] args ){
        ArrayList<ArrayList<Integer>> combinations = combinationSum(new int[]{2,3,6,7}, 7);
        System.out.println("Combinations:");
        for (ArrayList<Integer> list : combinations) {
            System.out.println(list);
        }

    }

}
