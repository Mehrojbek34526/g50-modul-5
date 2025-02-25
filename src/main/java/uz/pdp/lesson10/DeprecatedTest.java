package uz.pdp.lesson10;

/**
 Created by: Mehrojbek
 DateTime: 25/02/25 19:30
 **/
public class DeprecatedTest {

    @Deprecated(forRemoval = true, since = "7.0")
    public void print() {
        System.out.println("Hello World");
    }

}
