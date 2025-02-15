package uz.pdp.lesson6;

import uz.pdp.lesson4.Employee;
import uz.pdp.lesson4.EmployeeGenerateTest;
import uz.pdp.lesson4.GenderEnum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 Created by: Mehrojbek
 DateTime: 15/02/25 21:19
 **/
public class CollectorGroupByTest {

    public static void main(String[] args) {

        List<Employee> employees = EmployeeGenerateTest.generateEmployee(40);

//        Map<String, List<Employee>> employeeGroupedByDep = employees.stream()
//                .collect(Collectors.groupingBy(employee -> employee.getDepartment()));
//
//        employeeGroupedByDep.forEach((key, value) -> System.out.printf("%s -> %s\n\n", key, value));
//
//        Map<GenderEnum, List<Employee>> employeeGroupedByGender = employees.stream()
//                .collect(Collectors.groupingBy(Employee::getGender));
//
//        employeeGroupedByGender.forEach((key, value) -> System.out.printf("%s -> %s\n\n", key, value));

        Map<GenderEnum, Map<String, Map<String, Long>>> collect = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getGender,
                        Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.groupingBy(
                                        Employee::getPosition,
                                        Collectors.counting()
                                )
                        )));

        Map<GenderEnum, Map<String, Map<String, Long>>> collectByFor = new HashMap<>();

        for (Employee employee : employees) {

            GenderEnum gender = employee.getGender();

            Map<String, Map<String, Long>> departmentMap = collectByFor.getOrDefault(gender, new HashMap<>());

            String department = employee.getDepartment();

            Map<String, Long> positionMap = departmentMap.getOrDefault(department, new HashMap<>());

            String position = employee.getPosition();

            Long count = positionMap.getOrDefault(position, 0L);

            count++;

            positionMap.put(position, count);
            departmentMap.put(department, positionMap);
            collectByFor.put(gender, departmentMap);

        }

        System.out.println(collect);
        System.out.println(collectByFor);

    }

}
