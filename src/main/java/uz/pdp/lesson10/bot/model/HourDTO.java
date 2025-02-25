package uz.pdp.lesson10.bot.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 Created by: Mehrojbek
 DateTime: 25/02/25 21:22
 **/
@Data
public class HourDTO {

    private LocalDateTime time;

    @SerializedName("temp_c")
    private double tempC;

    private Condition condition;

    @SerializedName("wind_kph")
    private double windKph;

    private Integer humidity;

}
