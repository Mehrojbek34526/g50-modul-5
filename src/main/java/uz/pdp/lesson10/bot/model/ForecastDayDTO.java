package uz.pdp.lesson10.bot.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

/**
 Created by: Mehrojbek
 DateTime: 25/02/25 21:18
 **/
@Data
public class ForecastDayDTO {

    private LocalDate date;

    @SerializedName("date_epoch")
    private Long dateEpoch;

    private AstroDTO astro;

    private DayDTO day;

    private List<HourDTO> hour;

}
