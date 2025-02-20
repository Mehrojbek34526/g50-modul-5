package uz.pdp.lesson8;

import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 Created by: Mehrojbek
 DateTime: 20/02/25 20:21
 **/
//@MyAnnotation
public class Person {

    private String name;
    private int age;

    public final int number = 10;

    private Person() {
        this.name = "Name of person";
        this.age = 19;
    }

    private Person(@NotNull String name, int age) {
        this.name = name;
        this.age = age;
    }

    private void print() {
        System.out.println("Name: " + name);
    }

    private void print(int num) {
        System.out.println("Name: " + name + " num: " + num);
    }

    private int print(int num1, int num2) {
        return num1 + num2;
    }
}
