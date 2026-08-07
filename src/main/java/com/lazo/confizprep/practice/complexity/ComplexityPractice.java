package com.lazo.confizprep.practice.complexity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ComplexityPractice {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(
                10, 20, 30, 50, 20
        );

        boolean slowResult = containsDuplicateSlow(numbers);
        boolean fastResult = containsDuplicateFast(numbers);

        System.out.println("Slow result: " + slowResult);
        System.out.println("Fast result: " + fastResult);
    }

    /*
     * Time complexity: O(n²)
     * Space complexity: O(1)
     *
     * The method compares each element against the remaining elements.
     * It does not create a data structure that grows with the input size.
     */
    public static boolean containsDuplicateSlow(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if (numbers.get(i).equals(numbers.get(j))) {
                    return true;
                }
            }
        }

        return false;
    }

    /*
     * Time complexity: O(n) on average
     * Space complexity: O(n)
     *
     * The method traverses the list once and stores visited values
     * inside a HashSet.
     */
    public static boolean containsDuplicateFast(List<Integer> numbers) {
        Set<Integer> visitedNumbers = new HashSet<>();

        for (Integer number : numbers) {
            if (!visitedNumbers.add(number)) {
                return true;
            }
        }

        return false;
    }
}