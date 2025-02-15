package uz.pdp.lesson5;

import uz.pdp.lesson4.Employee;
import uz.pdp.lesson4.EmployeeGenerateTest;

import java.util.List;
import java.util.Optional;

/**
 Created by: Mehrojbek
 DateTime: 15/02/25 19:12
 **/
public class StreamFindTest {

    public static void main(String[] args) {

        List<Employee> employees = EmployeeGenerateTest.generateEmployee();

        Optional<Employee> optionalEmployee = employees.stream()
                .filter(employee -> {
                    System.out.println(Thread.currentThread().getName());
                    return employee.getSalary() > 900;
                })
                .filter(employee -> employee.getDepartment().equals("Sales"))
//                .findFirst();
                .findAny();

        optionalEmployee.ifPresent(System.out::println);

    }

}
