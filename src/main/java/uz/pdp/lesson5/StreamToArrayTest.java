package uz.pdp.lesson5;

import java.util.Arrays;
import java.util.List;

/**
 Created by: Mehrojbek
 DateTime: 15/02/25 19:52
 **/
public class StreamToArrayTest {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Integer[] array = numbers.stream()
                .filter(number -> number % 2 == 0)
//                .toArray(value -> new Integer[0]);
                .toArray(Integer[]::new);

        System.out.println(Arrays.toString(array));

    }

}
