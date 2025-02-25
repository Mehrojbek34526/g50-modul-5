package uz.pdp.lesson7;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 Created by: Mehrojbek
 DateTime: 18/02/25 21:18
 **/
public class LocalDateTimeGsonConverter extends TypeAdapter<LocalDateTime> {

    private DateTimeFormatter formatter = null;

    public LocalDateTimeGsonConverter(DateTimeFormatter formatter) {
        this.formatter = formatter;
    }

    public LocalDateTimeGsonConverter() {
    }

    @Override
    public void write(JsonWriter jsonWriter, LocalDateTime localDate) throws IOException {
        jsonWriter.value(localDate.toString());
    }

    @Override
    public LocalDateTime read(JsonReader jsonReader) throws IOException {
        String date = jsonReader.nextString();//1980-04-06 -> LocalDate

        if (formatter != null) {
            return LocalDateTime.parse(date, formatter);
        }

        return LocalDateTime.parse(date);
    }
}
