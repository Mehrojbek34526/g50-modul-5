package uz.pdp.lesson4.functionalinterface;

import uz.pdp.lesson4.Employee;
import uz.pdp.lesson4.EmployeeGenerateTest;
import uz.pdp.lesson4.GenderEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 Created by: Mehrojbek
 DateTime: 11/02/25 21:17
 **/
public class PredicateTest {

    public static void main(String[] args) {

        List<Employee> employees = EmployeeGenerateTest.generateEmployee();

//        Predicate<Employee> genderPredicate = employee -> employee.getGender().equals(GenderEnum.FEMALE);
//
//        Predicate<Employee> salaryPredicate = employee -> employee.getSalary() > 600;
//
//        Predicate<Employee> filter = genderPredicate.and(salaryPredicate);

        Predicate<Employee> filter = employee -> employee.getSalary() > 600;
        filter = filter.and(employee -> employee.getGender().equals(GenderEnum.FEMALE));
        filter = filter.and(employee -> employee.getDepartment().equals("Sales"));

        List<Employee> filteredEmployees = filter(employees, filter);
        filteredEmployees.forEach(System.out::println);

    }

    public static List<Employee> filter(List<Employee> employees, Predicate<Employee> predicate) {

        List<Employee> filteredEmployees = new ArrayList<>();

        for (Employee employee : employees) {
            if (predicate.test(employee)) {
                filteredEmployees.add(employee);
            }
        }

        return filteredEmployees;
    }

}
