package com.lazo.confizprep.practice.interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Duplicates {

    public static void main(String[] args) {
        System.out.println(containsDuplicateHashSet(new int[]{3, 5}));
    }

    public static boolean containsDuplicateBruteForce(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean containsDuplicateHashSet(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        for (int number : numbers) {
            if (!set.add(number)) {
                return true;
            }
        }

        return false;
    }
}
