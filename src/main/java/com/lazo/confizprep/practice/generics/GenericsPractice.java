package com.lazo.confizprep.practice.generics;

import com.lazo.confizprep.practice.streams.Developer;

import java.util.List;
import java.util.Optional;

public class GenericsPractice {

    public static void main(String[] args) {
        Box<String> textBox = new Box<>("Confiz");
        Box<Integer> numberBox = new Box<>(2500);

        Developer developer =
                new Developer("Jose", "Java", 10, 2500);

        Box<Developer> developerBox = new Box<>(developer);

        System.out.println(textBox.getValue());
        System.out.println(numberBox.getValue());
        System.out.println(developerBox.getValue());

        List<String> names = List.of(
                "Jose",
                "Ana",
                "Carlos"
        );

        Optional<String> firstName =
                GenericUtils.getFirst(names);

        firstName.ifPresent(System.out::println);

        boolean containsAna =
                GenericUtils.contains(names, "Ana");

        boolean containsMario =
                GenericUtils.contains(names, "Mario");

        System.out.println("Contains Ana: " + containsAna);
        System.out.println("Contains Mario: " + containsMario);

        Pair<Integer, String> employee =
                new Pair<>(1, "Jose");

        Pair<String, Double> salary =
                new Pair<>("Jose", 2500.0);

        System.out.println(employee.getKey());
        System.out.println(employee.getValue());

        System.out.println(salary.getKey());
        System.out.println(salary.getValue());
    }
}