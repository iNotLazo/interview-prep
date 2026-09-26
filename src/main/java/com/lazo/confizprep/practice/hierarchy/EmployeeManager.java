package com.lazo.confizprep.practice.hierarchy;

import java.util.*;

public class EmployeeManager {

    private static List<Employee> allEmployees = List.of(
            new Employee(1, "CEO", null),
            new Employee(2, "Alice", 1),
            new Employee(3, "Bob", 1),
            new Employee(4, "John", 2),
            new Employee(5, "Sarah", 2),
            new Employee(6, "Kevin", 3),
            new Employee(7, "Robert", 4)
    );
    private static Map<Integer, List<Employee>> directReports = new HashMap<>();

    public static void main(String[] args) {
        List<Employee> employees = getAllEmployees();

        for (Employee employee : employees) {
            if (employee.managerId() == null) {
                continue;
            }

            int managerId = employee.managerId();

            directReports.computeIfAbsent(managerId, k -> new ArrayList<>()).add(employee);
        }

        System.out.println(getAllSubordinatesDFS(2));
        System.out.println(getAllSubordinatesDFS(1));
        System.out.println(getAllSubordinatesDFS(4));
        System.out.println(getAllSubordinatesDFS(7));
    }

    public static List<Employee> getAllEmployees() {
        return allEmployees;
    }

    public static Map<Integer, List<Employee>> getDirectReports() {
        return directReports;
    }

    public static List<Employee> getAllSubordinatesDFS(int managerId) {
        List<Employee> result = new ArrayList<>();
        List<Employee> employees = directReports.getOrDefault(managerId, List.of());

        for (Employee employee : employees) {
            result.add(employee);

            result.addAll(getAllSubordinatesDFS(employee.id()));
        }

        return result;
    }

    public static List<Employee> getAllSubordinatesBFS(int managerId) {
        List<Employee> result = new ArrayList<>();
        Queue<Employee> queue = new ArrayDeque<>();

        queue.addAll(directReports.getOrDefault(managerId, List.of()));

        while (!queue.isEmpty()) {
            Employee employee = queue.poll();

            result.add(employee);

            queue.addAll(directReports.getOrDefault(employee.id(), List.of()));
        }

        return result;
    }
}