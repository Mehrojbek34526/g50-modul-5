package uz.pdp.lesson5;

import java.util.Random;
import java.util.stream.Stream;

/**
 Created by: Mehrojbek
 DateTime: 15/02/25 19:55
 **/
public class StreamGenTest {

    public static void main(String[] args) {

//        iterate();

//        generate();

    }

    private static void generate() {
        Random random = new Random();

        Stream<Integer> limit = Stream.generate(() -> random.nextInt(30, 80))
                .limit(10);

        limit.forEach(System.out::println);
    }

    private static void iterate() {
        Stream<Integer> iterate = Stream.iterate(0, i -> i + 1);

        Stream<Integer> limit = iterate.limit(100);

        limit.forEach(System.out::println);
    }

}
