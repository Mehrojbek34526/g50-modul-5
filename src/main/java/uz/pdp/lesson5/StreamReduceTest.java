package uz.pdp.lesson5;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 Created by: Mehrojbek
 DateTime: 15/02/25 19:43
 **/
public class StreamReduceTest {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

//        Optional<Integer> optionalInteger = numbers.stream()
//                .reduce((integer1, integer2) -> integer1 * integer2);
//
//        optionalInteger.ifPresent(System.out::println);

        Integer reduce = numbers.stream()
                .reduce(0, Integer::sum);

        System.out.println(reduce);

    }

}
