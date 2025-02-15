package uz.pdp.lesson5;

import java.util.List;
import java.util.stream.Stream;

/**
 Created by: Mehrojbek
 DateTime: 15/02/25 19:32
 **/
public class StreamMatchTest {

    public static void main(String[] args) {

//        anyMatch();

//        allMatch();

//        noneMatch();

    }

    private static void noneMatch() {
        List<Integer> integers = List.of(1, 22, 52, 14, 24, 20, 34);

        boolean noneMatch = integers.stream()
                .noneMatch(integer -> integer % 2 != 0);

        System.out.println(noneMatch);
    }

    private static void allMatch() {
        List<Integer> integers = List.of(12, 22, 52, 14, 24, 20, 34);

        boolean match = integers.stream()
                .allMatch(integer -> integer % 2 == 0);

        System.out.println(match);
    }

    private static void anyMatch() {

        List<Integer> integers = List.of(12, 22, 55, 14, 24, 20, 34);

        boolean match = integers
                .stream()
                .anyMatch(num -> num % 2 != 0);

        System.out.println(match);
    }

}
