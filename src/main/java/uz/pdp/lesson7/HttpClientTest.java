package uz.pdp.lesson7;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import uz.pdp.lesson5.Student;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

/**
 Created by: Mehrojbek
 DateTime: 18/02/25 21:46
 **/
public class HttpClientTest {



    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();

        URI uri = URI.create("https://cbu.uz/uz/arkhiv-kursov-valyut/json/");

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(uri)
                .build();

        HttpResponse.BodyHandler<String> responseBodyHandler = HttpResponse.BodyHandlers.ofString();

        HttpResponse<String> response = client.send(httpRequest, responseBodyHandler);

        String json = response.body();

        Gson gson = new Gson();

        TypeToken<List<Currency>> typeToken = new TypeToken<>(){};

        List<Currency> currencies = gson.fromJson(json, typeToken);

        System.out.println(currencies);

    }

}
