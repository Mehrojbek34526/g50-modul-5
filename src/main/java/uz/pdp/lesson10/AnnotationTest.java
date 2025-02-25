package uz.pdp.lesson10;

/**
 Created by: Mehrojbek
 DateTime: 25/02/25 19:29
 **/

public class AnnotationTest {

    public static void main(String[] args) {

//        DeprecatedTest test = new DeprecatedTest();
//        test.print();

        String[] test = test(null);
        System.out.println(test);

    }

//    @SafeVarargs
    private static String[] test(String... args) {
        return args;
    }


}
