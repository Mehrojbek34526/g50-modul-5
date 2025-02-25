package uz.pdp.lesson10.bot.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 Created by: Mehrojbek
 DateTime: 25/02/25 21:56
 **/
@Data
public class DayDTO {

    @SerializedName("avgtemp_c")
    private double avgTempC;

    @SerializedName("maxwind_kph")
    private double maxWindKph;

    @SerializedName("avghumidity")
    private double avgHumidity;

}
