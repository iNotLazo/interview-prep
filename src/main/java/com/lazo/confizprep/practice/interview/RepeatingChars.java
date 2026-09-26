package com.lazo.confizprep.practice.interview;

import java.util.HashMap;
import java.util.Map;

public class RepeatingChars {


    public static void main(String[] args) {
        System.out.println(firstNonRepeating("swiss"));
    }

    public static Character firstNonRepeating(String text) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            int frequency = map.getOrDefault(character, 0) + 1;
            map.put(character, frequency);
        }

        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);

            if (map.get(character) == 1) {
                return character;
            }
        }

        return null;
    }
}
