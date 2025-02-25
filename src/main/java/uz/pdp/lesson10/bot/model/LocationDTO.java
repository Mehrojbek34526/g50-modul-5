package uz.pdp.lesson10.bot.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 Created by: Mehrojbek
 DateTime: 25/02/25 21:10
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LocationDTO {

    private String name;

    private String region;

    private String country;

    private double lat;

    private double lon;

    @SerializedName("tz_id")
    private String tzId;

    @SerializedName("localtime_epoch")
    private long localtimeEpoch;

    private LocalDateTime localtime;

}
