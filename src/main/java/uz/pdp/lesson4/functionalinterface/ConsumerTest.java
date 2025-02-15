package uz.pdp.lesson4.functionalinterface;

import uz.pdp.lesson4.Employee;
import uz.pdp.lesson4.EmployeeGenerateTest;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.function.Consumer;

/**
 Created by: Mehrojbek
 DateTime: 11/02/25 21:27
 **/
public class ConsumerTest {

    public static void main(String[] args) {

        List<Employee> employees = EmployeeGenerateTest.generateEmployee();

        employees.forEach(System.out::println);
        System.out.println("---------");
        System.out.println("---------");

        Consumer<Employee> consumer = employee -> {

            LocalDate birthDate = employee.getBirthDate();

            int age = Period.between(birthDate, LocalDate.now()).getYears();
            employee.setAge(age);
        };

        changeEmployee(employees, consumer);

        employees.forEach(System.out::println);
    }

    private static void changeEmployee(List<Employee> employees, Consumer<Employee> consumer) {
        for (Employee employee : employees) {
            consumer.accept(employee);
        }
    }

}
