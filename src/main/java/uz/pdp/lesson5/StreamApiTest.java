package uz.pdp.lesson5;

import uz.pdp.lesson4.Employee;
import uz.pdp.lesson4.EmployeeGenerateTest;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 Created by: Mehrojbek
 DateTime: 13/02/25 20:46
 **/
public class StreamApiTest {

    public static void main(String[] args) {

        List<Employee> employees = EmployeeGenerateTest.generateEmployee();


//        Predicate<Employee> salaryPredicate = employee -> employee.getSalary() > 500;

//        List<Employee> filteredEmployees = employees.stream()
//                .filter(employee -> employee.getSalary() > 500)
//                .filter(employee -> employee.getDepartment().equals("Sales"))
//                .filter(employee -> employee.getGender().equals(GenderEnum.FEMALE))
//                .collect(Collectors.toList());

//        System.out.println(filteredEmployees);

//        imperativeAproach(employees);

//        Set<String> names = employees.stream()
//                .filter(employee -> employee.getSalary() > 500)
//                .filter(employee -> employee.getDepartment().equals("Sales"))
//                .filter(employee -> employee.getGender().equals(GenderEnum.FEMALE))
////                        .map(employee -> employee.getFirstName());
//                .map(Employee::getFirstName)
//                .collect(Collectors.toSet());
//
//        names.forEach(System.out::println);


//        Optional<Employee> optionalEmployee = employees.stream()
//                .filter(employee -> employee.getDepartment().equals("Sales"))
//                .filter(employee -> employee.getGender().equals(GenderEnum.FEMALE))
////                .max(Comparator.comparing(employee -> employee.getSalary()));
//                .max(Comparator.comparing(Employee::getSalary));
//
//        if(optionalEmployee.isPresent()) {
//            Employee employee = optionalEmployee.get();
//            System.out.println(employee);
//        }


        employees.forEach(System.out::println);
        System.out.println("----------");

        //vazifa skills bitta listga yig'ish
        //List<List<String>>

        //List<String>

//        List<String> collect = employees.stream()
//                .map(Employee::getSkills)
//                .flatMap(List::stream)
//                .distinct()//
//                .collect(Collectors.toList());
//
//        System.out.println(collect);

//        IntSummaryStatistics intSummaryStatistics = employees.stream()
//                .map(Employee::getSalary)
//                .mapToInt(salary -> salary)
//                .summaryStatistics();
//
//        System.out.println(intSummaryStatistics);


        /**
         * 1. Student classi ochilsin
         * Generate student method bo'lsin
         * yoshi 18 dan katta jinsi erkak studentlarni ismlarini listga yig'ing
         *
         * 2. Yoshi eng katta studentni ismini ekranga chiqaring
         */



        Stream<Employee> stream = employees.stream();

        List<Employee> collect = stream
                .filter(employee -> employee.getSalary() > 500)
                .map(employee -> employee)
                .skip(3)
                .limit(20)
                .collect(Collectors.toList());

        collect.forEach(System.out::println);

        System.out.println("----------");

        String[] strings = {"1","2","3","4","5"};

        Stream<String> stringStream = Arrays.stream(strings);


    }

    private static void imperativeAproach(List<Employee> employees) {
        List<String> filteredNames = new ArrayList<>();

        for (Employee employee : employees) {

            if (employee.getSalary() > 500 && employee.getDepartment().equals("Sales")) {
                filteredNames.add(employee.getFirstName());
            }

        }

        filteredNames.forEach(System.out::println);
    }

}
