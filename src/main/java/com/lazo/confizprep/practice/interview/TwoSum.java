package com.lazo.confizprep.practice.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Given an integer array and a target value, return the indices of two numbers whose sum equals the target.
public class TwoSum {

    //[2, 7, 11, 15], target 9
    //→ [0,1]
    //
    //[2, 11, 7, 15], target 9
    //→ [0,2]
    //
    //[3, 5, 8, 12], target 20
    //→ [2,3]
    public static void main(String[] args) {
        int[] numbers = new int[]{2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                return new int[]{map.get(numbers[i]), i};
            }

            map.put(target - numbers[i], i);
        }

        return new int[]{};
    }
}