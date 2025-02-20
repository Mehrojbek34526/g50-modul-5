package uz.pdp.lesson8;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 Created by: Mehrojbek
 DateTime: 20/02/25 20:21
 **/
public class PersonTest {

    public static void main(String[] args) {

//        Person person = new Person();

        Class<? extends Person> personClass = Person.class;

        MyAnnotation annotation = personClass.getDeclaredAnnotation(MyAnnotation.class);
        System.out.println(annotation);

//        Annotation[] annotations = personClass.getDeclaredAnnotations();
//        for (Annotation annotation : annotations) {
//            System.out.println(annotation);
//        }

//        accessConstructor(personClass);

//        notAccessFinalField(person, personClass);

//        privateMethodAccess(personClass, person);

//        accessToPrivateField(personClass, person);

//        System.out.println(personClass.getName());
//        System.out.println(personClass.getSimpleName());
//
//        for (Field declaredField : personClass.getDeclaredFields()) {
//            System.out.println(declaredField);
//        }

//        person.name="John";
//        person.number=78;
//        person.print();
    }

    private static void accessConstructor(Class<? extends Person> personClass) {
        try {

            Constructor<? extends Person> constructor = personClass.getDeclaredConstructor(String.class, int.class);
            constructor.setAccessible(true);
            Person person = constructor.newInstance("John", 18);
            System.out.println(person);

        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static void notAccessFinalField(Person person, Class<? extends Person> personClass) {
        try {
            System.out.println(person);

            Field field = personClass.getDeclaredField("number");

            field.setAccessible(true);

            field.set(person, 144);

            System.out.println(person.number + 10);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private static void privateMethodAccess(Class<? extends Person> personClass, Person person) {
        try {
            Method method = personClass.getDeclaredMethod("print", int.class, int.class);

            method.setAccessible(true);

            Object invoke = method.invoke(person, 45, 15);
            System.out.println(invoke);


        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static void accessToPrivateField(Class<? extends Person> personClass, Person person) {
        try {

            Field field = personClass.getDeclaredField("name");

            field.setAccessible(true);

//            Object value = field.get(person);
            System.out.println(person);

            field.set(person, "Yangi qiymat");

            System.out.println(person);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
