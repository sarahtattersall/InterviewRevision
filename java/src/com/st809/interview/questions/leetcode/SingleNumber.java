package com.st809.interview.questions.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingleNumber {
    public static int findSingleNumberExtraMemory(List<Integer> integers) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i : integers) {
            if (!counts.containsKey(i)) {
                counts.put(i, 1);
            }
            else {
                counts.put(i, counts.get(i) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() != 2) {
                return entry.getKey();
            }
        }
        throw new RuntimeException("All elements appear twice!");
    }
    public static int findSingleNumber(List<Integer> integers) {
        int singleNumber = 0;
        for (int i : integers) {
            singleNumber ^= i;
        }
        return singleNumber;
    }


}
