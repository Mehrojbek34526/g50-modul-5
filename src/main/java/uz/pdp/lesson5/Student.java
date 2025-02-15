package uz.pdp.lesson5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 Created by: Mehrojbek
 DateTime: 15/02/25 20:33
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student implements Comparable<Student> {

    private String firstName;
    private String lastName;
    private int age;

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.age, other.age);
    }
}
