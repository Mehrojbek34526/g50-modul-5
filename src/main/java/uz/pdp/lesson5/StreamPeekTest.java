package uz.pdp.lesson5;

import uz.pdp.lesson4.Employee;
import uz.pdp.lesson4.EmployeeGenerateTest;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

/**
 Created by: Mehrojbek
 DateTime: 15/02/25 19:24
 **/
public class StreamPeekTest {

    public static void main(String[] args) {

        List<Employee> employees = EmployeeGenerateTest.generateEmployee(10);

//        employees.stream()
//                .forEach(System.out::println);

        employees.stream()
//                .peek(System.out::println)
                .peek(employee -> {
                    int age = Period.between(employee.getBirthDate(), LocalDate.now()).getYears();
                    employee.setAge(age);
                })
                .forEach(System.out::println);

    }

}
