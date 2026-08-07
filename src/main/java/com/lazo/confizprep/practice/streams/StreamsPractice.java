package com.lazo.confizprep.practice.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StreamsPractice {

    public static void main(String[] args) {
        List<Developer> developers = List.of(
                new Developer("Jose", "Java", 10, 2500),
                new Developer("Ana", "Python", 4, 2200),
                new Developer("Carlos", "Java", 3, 1900),
                new Developer("Laura", "JavaScript", 6, 2300),
                new Developer("Mario", "Java", 7, 2800)
        );

        System.out.println(developers);

        List<String> experiencedDevs = developers
                .stream()
                .filter(dev -> dev.yearsOfExperience() >= 5)
                .map(Developer::name)
                .toList();
        System.out.println(experiencedDevs);

        List<String> highestSalaryDevs = developers
                .stream()
                .filter(dev -> dev.salary() >= 2300)
                .map(Developer::name)
                .toList();
        System.out.println(highestSalaryDevs);

        List<String> capsDevNames = developers
                .stream()
                .map(developer -> developer.name().toUpperCase())
                .toList();
        System.out.println(capsDevNames);

        List<Developer> developersByExperience = developers.stream()
                .sorted(
                        Comparator.comparingInt(
                                Developer::yearsOfExperience
                        ).reversed()
                )
                .toList();

        System.out.println(developersByExperience);

        double averageSalary = developers
                .stream()
                .mapToDouble(Developer::salary)
                .average()
                .orElse(0.0);
        System.out.println(averageSalary);

        Optional<Developer> highestPaidDeveloper = developers.stream()
                .max(Comparator.comparingDouble(Developer::salary));
        highestPaidDeveloper.ifPresent(System.out::println);
    }
}