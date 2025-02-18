package uz.pdp.lesson4;

import com.google.gson.annotations.Expose;
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

    @Expose
    private String firstName;

    @Expose
    private String lastName;

    private LocalDate birthDate;

    //maosh
    private int salary;

    //bo'lim
    private String department;

    @Expose(deserialize = false)
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

    public String toJson(){
        //  {
        //    "firstName": "Valijon",
        //    "lastName": "Valiyev",
        //    "age": 28,
        //    "married": true,
        //    "skills": [
        //      "Networking",
        //      "Problem-solving",
        //      "Self-motivated"
        //    ],
        //    "address": {
        //      "city": "Tashkent",
        //      "street": "Navoiy ko'cha"
        //    }
        //  }

        List<String> skillsWith = skills.stream()
                .map(s -> "\"" + s + "\"")
                .toList();

        return "{" +
                "\"firstName\":\"" + firstName + "\"," +
                "\"lastName\":\"" + lastName + "\"," +
                "\"birthDate\":\"" + birthDate + "\"," +
                "\"salary\":" + salary + "," +
                "\"department\":\"" + department + "\"," +
                "\"position\":\"" + position + "\"," +
                "\"gender\":\"" + gender + "\"," +
                "\"city\":\"" + city + "\"," +
                "\"age\":" + age + "," +
                "\"skills\":[" + String.join(",", skillsWith) + "]," +
                "\"address\":" + address.toJson() +
                "}";
    }

}
