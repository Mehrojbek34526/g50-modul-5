package uz.pdp.lesson7;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 Created by: Mehrojbek
 DateTime: 18/02/25 21:00
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {

    private Integer bookId;

    private String title;

    private String bookAuthor;

    //published_date
//    @SerializedName("published_date")
    private LocalDate publishedDate;

    private LocalDateTime writtenDateTime;

    private Double price;

    private boolean available;

    private List<String> tags;

}
