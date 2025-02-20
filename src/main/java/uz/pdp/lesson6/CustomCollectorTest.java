package uz.pdp.lesson6;

import uz.pdp.lesson4.EmployeeGenerateTest;

import java.util.stream.Collectors;

/**
 Created by: Mehrojbek
 DateTime: 20/02/25 19:30
 **/
public class CustomCollectorTest {

    public static void main(String[] args) {

        String json = EmployeeGenerateTest.generateEmployee(5)
                .stream()
                .collect(ToJsonCollector.getInstance());

        System.out.println(json);

    }

}
