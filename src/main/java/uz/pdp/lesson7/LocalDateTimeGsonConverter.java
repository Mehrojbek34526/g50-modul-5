package uz.pdp.lesson7;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 Created by: Mehrojbek
 DateTime: 18/02/25 21:18
 **/
public class LocalDateTimeGsonConverter extends TypeAdapter<LocalDateTime> {
    @Override
    public void write(JsonWriter jsonWriter, LocalDateTime localDate) throws IOException {
        jsonWriter.value(localDate.toString());
    }

    @Override
    public LocalDateTime read(JsonReader jsonReader) throws IOException {
        String date = jsonReader.nextString();//1980-04-06 -> LocalDate
        return LocalDateTime.parse(date);
    }
}
