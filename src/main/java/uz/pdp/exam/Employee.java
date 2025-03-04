package uz.pdp.exam;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.lesson4.GenderEnum;

import java.time.LocalDate;
import java.util.List;

/**
 Created by: Mehrojbek
 DateTime: 04/03/25 19:07
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {

    private int id;

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private GenderEnum gender;
    private List<String> hobbies;

}
