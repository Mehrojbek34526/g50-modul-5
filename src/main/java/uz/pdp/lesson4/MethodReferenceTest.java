package uz.pdp.lesson4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 Created by: Mehrojbek
 DateTime: 13/02/25 19:30
 **/
public class MethodReferenceTest {

    public static void main(String[] args) {

//        staticMethodRef();

//        instanceMethodRef();

//        instanceArbitraryObjectMethodRef();
    }

    private static void instanceArbitraryObjectMethodRef() {

        List<String> names = Arrays.asList("John", "Black","Brown","Jane","Kate","Bob");

        List<Integer> lengths = new ArrayList<>();

//        Function<String, Integer> nameLength = str-> str.length();
        Function<String, Integer> nameLength = String::length;

        for (String name : names) {

            Integer length = nameLength.apply(name);
            lengths.add(length);

        }

        System.out.println(lengths);
    }

    private static void instanceMethodRef() {

        List<Integer> numbers = Arrays.asList(12, 3, 8, 46, 15, 36, 27, 18, 29, 10);
        List<Integer> oddNumbers = new ArrayList<>();

//        Consumer<Integer> integerConsumer = number -> oddNumbers.add(number);
        Consumer<Integer> integerConsumer = oddNumbers::add;

        System.out.println(oddNumbers);

        for (Integer number : numbers) {
            if (number % 2 != 0) {
                integerConsumer.accept(number);
            }
        }

        System.out.println(oddNumbers);

    }

    private static void staticMethodRef() {

        List<Integer> numbers = Arrays.asList(12, 2, 8, 46, 15, 36, 27, 18, 29, 10);
//        List<Integer> numbers2 = Arrays.asList(12, 2, 8, 46, 15, 36, 27, 18, 29, 10);
//        List<Integer> numbers3 = Arrays.asList(12, 2, 8, 46, 15, 36, 27, 18, 29, 10);
//
////        Consumer<List<Integer>> sortConsumer = list -> Collections.sort(list);
//        Consumer<List<Integer>> sortConsumer = Collections::sort;
//
//        sortConsumer.accept(numbers);
//        sortConsumer.accept(numbers2);
//        sortConsumer.accept(numbers3);

//        Function<List<Integer>, List<String>> function = list -> MethodReferenceTest.intToString(list);
        Function<List<Integer>, List<String>> function = MethodReferenceTest::intToString;


        //        List<String> strings = MethodReferenceTest::intToString;
//        System.out.println(strings);

    }

    public static List<String> intToString(List<Integer> numbers) {
        List<String> strings = new ArrayList<>();
        for (Integer number : numbers) {
            strings.add(String.valueOf(number));
        }
        return strings;
    }

}
