package uz.pdp.lesson6;

import uz.pdp.lesson4.Employee;
import uz.pdp.lesson4.EmployeeGenerateTest;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 Created by: Mehrojbek
 DateTime: 18/02/25 19:12
 **/
public class CollectorsToListTest {

    public static void main(String[] args) {
//
//        List<String> collect = EmployeeGenerateTest.generateEmployee().stream()
//                .collect(Collectors.flatMapping(employee -> employee.getSkills().stream(), Collectors.toList()));


        Stream<String> stream = Stream.of("qora", "oq", "yashil", "sariq");

        Map<Boolean, List<Employee>> collect = EmployeeGenerateTest.generateEmployee().stream()
                .collect(Collectors.partitioningBy(employee -> employee.getSalary() > 700));

        OptionalDouble average = EmployeeGenerateTest.generateEmployee().stream()
                .map(Employee::getSalary)
                .mapToDouble(value -> value)
                .average();

//        average.ifPresent(System.out::println);

        Map<String, Double> collect1 = EmployeeGenerateTest.generateEmployee().stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));

        collect1.forEach((department, employee) -> System.out.printf("%s: %s\n", department, employee));

//        double sum = EmployeeGenerateTest.generateEmployee().stream()
//                .map(Employee::getSalary)
//                .mapToDouble(value -> value)
//                .sum();
//
//        System.out.printf("%.2f%n", sum);

//        collect.forEach((aBoolean, employees) -> System.out.printf("%s -> %s%n", aBoolean, employees));

//        collectorsJoining(stream);

//        toCustomMap();

//        toCollectionTest();

//        toMapTest();

//        mutableList();

//        immutableList();

    }

    private static void collectorsJoining(Stream<String> stream) {
        String collect = stream
                .collect(Collectors.joining(
                        ", ", "[", "]"
                ));

        System.out.printf("collect = %s\n", collect);
    }

    private static void toCustomMap() {
        LinkedHashMap<String, Employee> collect = EmployeeGenerateTest.generateEmployee().stream()
                .collect(Collectors.toMap(
                        Employee::getFirstName,
                        employee -> employee,
                        (a, b) -> b,
                        LinkedHashMap::new
                ));

        System.out.println(collect.getClass());
    }

    private static void toCollectionTest() {
        LinkedList<Employee> collect = EmployeeGenerateTest.generateEmployee().stream()
                .filter(employee -> employee.getAge() > 18)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    private static void toMapTest() {
        Map<String, Employee> collect = EmployeeGenerateTest.generateEmployee(100).stream()
                .collect(Collectors.toMap(Employee::getFirstName, employee -> employee, (a, b) -> b));
    }

    private static void mutableList() {
        List<String> fullNames = EmployeeGenerateTest.generateEmployee().stream()
                .map(employee -> employee.getFirstName() + " " + employee.getLastName())
                .collect(Collectors.toList());

        fullNames.add("John");
    }

    private static void immutableList() {
        List<String> fullNames = EmployeeGenerateTest.generateEmployee().stream()
                .map(employee -> employee.getFirstName() + " " + employee.getLastName())
                .toList();

        fullNames.add("John");
    }

}
