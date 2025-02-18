package uz.pdp.lesson7;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.LocalDate;

/**
 Created by: Mehrojbek
 DateTime: 18/02/25 21:18
 **/
public class LocalDateGsonConverter extends TypeAdapter<LocalDate> {
    @Override
    public void write(JsonWriter jsonWriter, LocalDate localDate) throws IOException {
        jsonWriter.value(localDate.toString());
    }

    @Override
    public LocalDate read(JsonReader jsonReader) throws IOException {
        String date = jsonReader.nextString();//1980-04-06 -> LocalDate
        return LocalDate.parse(date);
    }
}
