package com.lazo.confizprep.practice.interview;

import java.util.HashMap;
import java.util.Map;

public class Anagrams {

    public static void main(String[] args) {
        System.out.println(isAnagram("aabbc", "abcab"));
    }

    public static boolean isAnagram(String first, String second) {
        if (first.length() != second.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < first.length(); i++) {
            char character = first.charAt(i);

            map.put(character, map.getOrDefault(character, 0) + 1);
        }

        for (int i = 0; i < second.length(); i++) {
            char character = second.charAt(i);

            map.put(character, map.getOrDefault(character, 0) - 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }

        return true;
    }
}
