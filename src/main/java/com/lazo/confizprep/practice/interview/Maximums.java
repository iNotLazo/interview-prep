package com.lazo.confizprep.practice.interview;

public class Maximums {

    public static void main(String[] args) {
        System.out.println(secondLargest(new int[]{10, 5, 8, 20, 15}));
    }

    //“The largest number that is smaller than max.”
    public static Integer secondLargest(int[] numbers) {
        if (numbers == null || numbers.length < 2) {
            return null;
        }

        int max = numbers[0];
        Integer secondHighest = null;

        for (int number : numbers) {
            if (number > max) {
                secondHighest = max;
                max = number;
            } else if (number < max && (secondHighest == null || number > secondHighest)) {
                secondHighest = number;
            }
        }

        return secondHighest;
    }
}
