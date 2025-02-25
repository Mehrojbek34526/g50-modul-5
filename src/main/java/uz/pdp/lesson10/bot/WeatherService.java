package uz.pdp.lesson10.bot;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import uz.pdp.lesson10.bot.model.WeatherDTO;
import uz.pdp.lesson7.LocalDateGsonConverter;
import uz.pdp.lesson7.LocalDateTimeGsonConverter;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 Created by: Mehrojbek
 DateTime: 25/02/25 21:03
 **/
public class WeatherService {

    public WeatherDTO info(String city, int days) {

        try {
            String url = "https://api.weatherapi.com/v1/forecast.json?key=8099eec7035c40c79db80612241510&q=%s&days=%d"
                    .formatted(city, days);

            HttpClient httpClient = HttpClient.newHttpClient();

            URI uri = URI.create(url);

            HttpRequest request = HttpRequest.newBuilder().GET().uri(uri).build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDate.class, new LocalDateGsonConverter())
                    .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeGsonConverter(formatter))
                    .create();
            return gson.fromJson(json, WeatherDTO.class);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
