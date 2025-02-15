package uz.pdp.lesson4;

/**
 Created by: Mehrojbek
 DateTime: 11/02/25 19:36
 **/
public interface UniversalFilter<E> {

    boolean test(E e);


    private void hello(){
        System.out.println("hello");
    }
}
