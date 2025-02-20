package uz.pdp.lesson6;

import uz.pdp.lesson4.Employee;
import uz.pdp.lesson4.EmployeeGenerateTest;

import java.util.List;
import java.util.stream.Collectors;

/**
 Created by: Mehrojbek
 DateTime: 20/02/25 20:18
 **/
public class MyToListCollectorTest {

    public static void main(String[] args) {

        List<Employee> collect = EmployeeGenerateTest.generateEmployee()
                .stream()
                .filter(employee -> employee.getDepartment().equals("Sales"))
                .collect(MyToListCollector.getInstance());

        System.out.println(collect);

    }

}
