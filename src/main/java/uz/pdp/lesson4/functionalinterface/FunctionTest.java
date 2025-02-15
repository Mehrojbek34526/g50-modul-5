package uz.pdp.lesson4.functionalinterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 Created by: Mehrojbek
 DateTime: 11/02/25 21:34
 **/
public class FunctionTest {

    public static void main(String[] args) {

        List<String> numberString = List.of("12", "67", "85", "90", "5", "9");

        Function<String, Integer> mapToIntegerFunction = str -> Integer.parseInt(str);

        List<Integer> numbers = map(numberString, mapToIntegerFunction);

        System.out.println(numbers);

    }

    private static List<Integer> map(List<String> numberString, Function<String, Integer> mapToIntegerFunction) {

        List<Integer> numbers = new ArrayList<>();

        for (String string : numberString) {

            Integer number = mapToIntegerFunction.apply(string);
            numbers.add(number);

        }

        return numbers;
    }

}
