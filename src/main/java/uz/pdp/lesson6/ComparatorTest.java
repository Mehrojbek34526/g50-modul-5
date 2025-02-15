package uz.pdp.lesson6;

import uz.pdp.lesson4.Employee;
import uz.pdp.lesson4.EmployeeGenerateTest;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 Created by: Mehrojbek
 DateTime: 15/02/25 20:40
 **/
public class ComparatorTest {

    public static void main(String[] args) {

        List<Employee> employees = EmployeeGenerateTest.generateEmployee(20);

//        Comparator.comparing(o -> o)

//        Collections.sort(employees,(o1, o2) -> Integer.compare(o2.getSalary(), o1.getSalary()));
//        Collections.sort(employees, Comparator.comparing(employee -> employee.getSalary()));

//        employees.forEach(employee -> System.out.println(employee.getSalary()));

        Function<Employee, Integer> keyExtractorBySalary = Employee::getSalary;

        Function<Employee, String> keyExtractorByDepartment = Employee::getDepartment;

        Comparator<Employee> comparator = Comparator.comparing(
                keyExtractorByDepartment,
                Comparator.reverseOrder()
        ).thenComparing(
                keyExtractorBySalary,
                Comparator.naturalOrder()
        );

        employees.stream()
//                .sorted((o1, o2) -> Integer.compare(o1.getSalary(), o2.getSalary()))
                .sorted(comparator)
                .forEach(employee -> System.out.println(employee.getDepartment() + " " + employee.getSalary()));


    }

}
