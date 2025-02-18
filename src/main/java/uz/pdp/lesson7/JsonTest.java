package uz.pdp.lesson7;

import uz.pdp.lesson4.Employee;
import uz.pdp.lesson4.EmployeeGenerateTest;

/**
 Created by: Mehrojbek
 DateTime: 18/02/25 20:46
 **/
public class JsonTest {

    public static void main(String[] args) {

        Employee employee = EmployeeGenerateTest.generateEmployee().get(0);
        System.out.println(employee);
        System.out.println();
        System.out.println(employee.toJson());

    }

}
