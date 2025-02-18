package uz.pdp.lesson7;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import uz.pdp.lesson4.Employee;
import uz.pdp.lesson4.EmployeeGenerateTest;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 Created by: Mehrojbek
 DateTime: 18/02/25 20:54
 **/
public class GsonTest {

    public static void main(String[] args) {

        Gson gson = new GsonBuilder()
//                .setFieldNamingStrategy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
//                .setFieldNamingStrategy(FieldNamingPolicy.UPPER_CASE_WITH_UNDERSCORES)
                .excludeFieldsWithoutExposeAnnotation()
                .registerTypeAdapter(LocalDate.class, new LocalDateGsonConverter())
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeGsonConverter())
                .setPrettyPrinting()
                .create();

//        List<Employee> employees = EmployeeGenerateTest.generateEmployee(3);

//        String json = gson.toJson(employees);

//        Book book = new Book(
//                1,
//                "O`tkan kunlar",
//                "Abdulla Qodiriy",
//                LocalDate.of(1980,4,6),
//                LocalDateTime.of(1978,5,12,12,45),
//                120000D,
//                true,
//                List.of("Roman","Sarguzash")
//        );
//
//        String json = gson.toJson(book);
//
//        System.out.println(json);
//
//        System.out.println();
//
//        Book bookFromJson = gson.fromJson(json, Book.class);
//        System.out.println(bookFromJson);

        List<Employee> employees = EmployeeGenerateTest.generateEmployee(2);

        String json = gson.toJson(employees);
        System.out.println(json);

        TypeToken<List<Employee>> typeToken = new TypeToken<>() {};

        List<Employee> list = gson.fromJson(json, typeToken.getType());

        list.forEach(System.out::println);


    }

}
