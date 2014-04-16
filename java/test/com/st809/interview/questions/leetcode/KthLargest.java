package com.st809.interview.questions.leetcode;

import com.st809.interview.sort.Sort;

import java.util.Arrays;
import java.util.List;

public class KthLargest {

    /**
     *
     * @param values
     * @param k - pre k < values.size()
     * @return kth largest element.
     */
    public static int kthLargest(List<Integer> values, int k) {
        return randomSelect(values, 0, values.size()-1, k);

    }

    private static int randomSelect(List<Integer> values, int lo, int hi, int k) {

        if (lo == hi) {
            return values.get(lo);
        }

        int pivot = Sort.randomPartition(values, lo, hi);
        int numberInHigher =  hi - pivot + 1;
        if (numberInHigher == k) {
            return values.get(pivot);
        } else if (numberInHigher < k) {
            return randomSelect(values, lo, pivot -1, k-numberInHigher);
        } else {
            return randomSelect(values, pivot +1, hi, k);
        }


    }

    public static void main(String[] arg) {
        System.out.println("4th largest: " + kthLargest(Arrays.asList(13,1,2,3,8,9,10,4,5,6,7,11,12), 4));
    }

}
