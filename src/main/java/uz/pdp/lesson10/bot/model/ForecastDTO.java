package uz.pdp.lesson10.bot.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

/**
 Created by: Mehrojbek
 DateTime: 25/02/25 21:17
 **/
@Data
public class ForecastDTO {

    @SerializedName("forecastday")
    private List<ForecastDayDTO> forecastDay;

}
