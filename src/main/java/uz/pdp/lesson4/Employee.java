package uz.pdp.lesson4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 Created by: Mehrojbek
 DateTime: 11/02/25 19:07
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {

    private String firstName;

    private String lastName;

    private LocalDate birthDate;

    //maosh
    private int salary;

    //bo'lim
    private String department;

    //lavozim
    private String position;

    //jinsi
    private GenderEnum gender;

    //shahri
    private String city;

    //calculate by birthDate
    private Integer age;

    //qobiliyatlari
    private List<String> skills;

    //manzil
    private Address address;

}
