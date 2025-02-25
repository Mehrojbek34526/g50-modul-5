package uz.pdp.lesson10.bot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 Created by: Mehrojbek
 DateTime: 25/02/25 21:09
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WeatherDTO {

    private LocationDTO location;

    private CurrentDTO current;

    private ForecastDTO forecast;

}
