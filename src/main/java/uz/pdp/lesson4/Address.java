package uz.pdp.lesson4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.text.StrBuilder;

/**
 Created by: Mehrojbek
 DateTime: 15/02/25 20:48
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Address {

    private String street;
    private String city;

    public String toJson(){
        StrBuilder strBuilder = new StrBuilder();
        strBuilder.append("{")
                .append("\"street\":\"").append(street).append("\",")
                .append("\"city\":\"").append(city).append("\"")
                .append("}");
        return strBuilder.toString();
    }

}
