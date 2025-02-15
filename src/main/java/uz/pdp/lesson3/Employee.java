package uz.pdp.lesson3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 Created by: Mehrojbek
 DateTime: 06/02/25 21:06
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {

    private String firstName;

    private String lastName;

    private LocalDate birthDate;

    private String bloodGroup;

    private String country;

    private String city;

    private String addressLine;

    private String position;

}
