package uz.pdp.lesson4.functionalinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.LongToIntFunction;
import java.util.function.ToIntFunction;

/**
 Created by: Mehrojbek
 DateTime: 13/02/25 19:19
 **/
public class PrimitiveFunctionsTest {

    public static void main(String[] args) {

//        IntPredicate
//        IntFunction

        ToIntFunction<String> toIntFunction = s -> Integer.parseInt(s);

        LongToIntFunction longToIntFunction = l -> (int) l;

        List<String> numbers = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");

        for (String numberStr : numbers) {
            int number = toIntFunction.applyAsInt(numberStr);
            System.out.println(number);
        }

    }

}
