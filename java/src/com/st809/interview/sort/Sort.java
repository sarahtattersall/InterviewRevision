package com.st809.interview.sort;

import com.st809.interview.datastructures.heap.ArrayHeap;

import java.util.*;

/**
 * Static class for sort algorithms
 */
public class Sort {

    private Sort() {
    }

    public static Collection<Integer> heapSort(Collection<Integer> values) {
        ArrayHeap heap = new ArrayHeap(values);
        return heap.sortIntoOrder();
    }

    public static Collection<Integer> quickSort(List<Integer> values) {
        quickSort(values, 0, values.size() - 1);
        return values;
    }

    public static Collection<Integer> mergeSort(List<Integer> values) {
        mergeSort(values, 0, values.size() - 1);
        return values;
    }

    private static void mergeSort(List<Integer> values, int lo, int hi) {
        if (lo < hi) {
            int middle = (lo + hi) /2;
            mergeSort(values, lo, middle);
            mergeSort(values, middle + 1, hi);
            merge(values, lo, middle, hi);
        }
    }

    private static void merge(List<Integer> values, int lo, int middle, int hi) {
        Integer[] auxillary = Arrays.copyOfRange(values.toArray(new Integer[values.size()]), lo, hi + 1);

        int i = 0; // Points to start of left list
        int j = middle - lo + 1; // Points to start of right list
        int k = lo; //Points to actual position in values

        while (i <= middle - lo && j <= hi - lo) {
            if (auxillary[i] <= auxillary[j]) {
                values.set(k, auxillary[i]);
                i++;
            } else {
                values.set(k, auxillary[j]);
                j++;
            }
            k++;
        }

        while (i <= middle - lo) {
            values.set(k, auxillary[i]);
            k++;
            i++;
        }
    }


    /**
     * In place modifies the array values.
     *
     * @param values
     * @param lo
     * @param hi
     */
    private static void quickSort(List<Integer> values, int lo, int hi) {
        if (lo < hi) {
            int q = partition(values, lo, hi);
            quickSort(values, lo, q - 1);
            quickSort(values, q + 1, hi);
        }

    }

    /**
     *
     * Calculates a pivot and moves values between lo and hi around this pivot
     * I.e. everything < values[pivot] is to the left of it, everything else
     * is to the right
     *
     * It picks the last item to be the pivot and orders everything around it
     * returning the new index of the pivot item
     *
     * @param values
     * @param lo
     * @param hi
     * @return pivot values new index
     */
    private static int partition(List<Integer> values, int lo, int hi) {
        int pivotValue = values.get(hi);
        int i = lo - 1;
        for (int j = lo; j < hi; j++) {
            if (values.get(j) < pivotValue) {
                i++;
                swap(values, i, j);
            }

        }
        swap(values, i+1, hi);
        return i+1;
    }


    /**
     * Picks a random pivot in order to try and acheive average case run time
     *
     * Then calls partition with random pivot
     *
     * @param lo
     * @param hi
     * @return partitioned array
     */
    private static int randomPartition(List<Integer> values, int lo, int hi) {
        int pivot = randomInt(lo, hi);
        swap(values, pivot, hi);
        return partition(values, lo, hi);

    }

    /**
     *
     * @param min
     * @param max
     * @return pseudo random number between min and max inclusive
     */
    private static int randomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    private static void swap(List<Integer> values, int i, int j) {
        int tmp = values.get(i);
        values.set(i, values.get(j));
        values.set(j, tmp);
    }




    public static void main(String[] args) {
        printCollection(mergeSort(Arrays.asList(1,6,8,2,7,2,42,2,88,15,27,47,29,85)));
        printCollection(quickSort(Arrays.asList(1,6,8,2,7,2,42,2,88,15,27,47,29,85)));
        printCollection(heapSort(Arrays.asList(1,6,8,2,7,2,42,2,88,15,27,47,29,85)));
    }

    public static void printCollection(Collection<Integer> collection) {
        System.out.print("{");
        for (int i : collection) {
            System.out.print(i + ", ");
        }
        System.out.println("}");
    }
}
