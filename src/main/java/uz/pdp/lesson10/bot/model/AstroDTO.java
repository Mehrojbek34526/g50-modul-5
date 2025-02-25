package uz.pdp.lesson10.bot.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 Created by: Mehrojbek
 DateTime: 25/02/25 21:19
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AstroDTO {

    private String sunrise;

    private String sunset;

    private String moonrise;

    private String moonset;

    @SerializedName("moon_phase")
    private String moonPhase;

    @SerializedName("moon_illumination")
    private Integer moonIllumination;

    @SerializedName("is_moon_up")
    private Integer isMoonUp;

    @SerializedName("is_sun_up")
    private Integer isSunUp;

}
