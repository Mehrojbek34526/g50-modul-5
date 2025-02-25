package uz.pdp.lesson10.bot.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 Created by: Mehrojbek
 DateTime: 25/02/25 21:13
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CurrentDTO {

    @SerializedName("temp_c")
    private double tempC;

    private Condition condition;

    @SerializedName("wind_kph")
    private double windKph;

}
