package uz.pdp.lesson6;

import uz.pdp.lesson4.Employee;
import uz.pdp.lesson4.EmployeeGenerateTest;

import java.util.List;
import java.util.Map;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

/**
 Created by: Mehrojbek
 DateTime: 15/02/25 21:07
 **/
public class CollectorsTest {

    public static void main(String[] args) {

        List<Employee> employees = EmployeeGenerateTest.generateEmployee();

        Map<String, Employee> map = employees.stream()
                .collect(Collectors.toMap(
                        Employee::getDepartment,
                        employee -> employee,
                        (value1, value2) -> value2
                ));

        System.out.println(map);

//        List<String> departments = employees.stream()
//                .map(Employee::getDepartment)
//                .collect(Collectors.toList());

//        Set<String> departments = employees.stream()
//                .map(Employee::getDepartment)
//                .collect(Collectors.toSet());

//        departments.forEach(System.out::println);

    }

}
