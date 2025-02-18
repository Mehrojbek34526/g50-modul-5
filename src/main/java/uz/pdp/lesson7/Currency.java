package uz.pdp.lesson7;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 Created by: Mehrojbek
 DateTime: 18/02/25 21:57
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Currency {

    private Integer id;

    @SerializedName("Code")
    private String code;

    @SerializedName("Ccy")
    private String ccy;

    @SerializedName("CcyNm_RU")
    private String nameRu;

    @SerializedName("CcyNm_UZ")
    private String nameUz;

    @SerializedName("CcyNm_UZC")
    private String nameKr;

    @SerializedName("CcyNm_EN")
    private String nameEn;

    @SerializedName("Nominal")
    private Integer nominal;

    @SerializedName("Rate")
    private Double rate;

    @SerializedName("Diff")
    private Double diff;

    @SerializedName("Date")
    private String date;
}
