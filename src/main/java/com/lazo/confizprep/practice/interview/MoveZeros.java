package com.lazo.confizprep.practice.interview;

import java.util.*;

public class MoveZeros {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(moveZeros(new int[]{0, 1, 0, 3, 12})));
    }

    //Given an array of integers, move all zero values to the end of the array while preserving the relative order of the non-zero elements.
    //
    //Do this in-place, meaning you should modify the original array instead of creating another array containing all the elements.
    public static int[] moveZeros(int[] numbers) {
        int writeIndex = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != 0) {
                numbers[writeIndex] = numbers[i];
                writeIndex++;
            }
        }

        while (writeIndex < numbers.length) {
            numbers[writeIndex] = 0;
            writeIndex++;
        }

        return numbers;
    }
}