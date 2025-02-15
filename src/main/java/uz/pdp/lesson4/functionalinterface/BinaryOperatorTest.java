package uz.pdp.lesson4.functionalinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

/**
 Created by: Mehrojbek
 DateTime: 13/02/25 19:14
 **/
public class BinaryOperatorTest {

    public static void main(String[] args) {

        BinaryOperator<Integer> binaryOperator = (a, b) -> a + b;

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        int sum = 0;
        for (int i = 0; i < numbers.size() - 1; i += 2) {
            sum += binaryOperator.apply(numbers.get(i), numbers.get(i + 1));
        }

        System.out.println(sum);

    }

}
