package uz.pdp.lesson4.functionalinterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

/**
 Created by: Mehrojbek
 DateTime: 11/02/25 21:47
 **/
public class UnaryOperatorTest {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        UnaryOperator<Integer> unaryOperator = x -> x * 2;

        List<Integer> numbers2x = new ArrayList<>();

        for (Integer number : numbers) {
            Integer result = unaryOperator.apply(number);
            numbers2x.add(result);
        }

        System.out.println(numbers);
        System.out.println(numbers2x);

    }

}
