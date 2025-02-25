package uz.pdp.lesson10.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import uz.pdp.lesson10.bot.model.ForecastDayDTO;
import uz.pdp.lesson10.bot.model.WeatherDTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 Created by: Mehrojbek
 DateTime: 25/02/25 20:51
 **/
public class WeatherBotService extends TelegramLongPollingBot {

    private Map<Long, String> addressMap = new HashMap<>();

    private final String username;

    public WeatherBotService(String token, String username) {
        super(token);
        this.username = username;
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage()) {
            processMsg(update.getMessage());
        }

    }

    private void processMsg(Message message) {

        if (message.hasText()) {
            processMsgText(message);
        }

    }

    private void processMsgText(Message message) {

        String text = message.getText();
        Long chatId = message.getChatId();

        if (text.equals("/start")) {

            String sendText = "Xush kelibsiz boy ota. Qayerni ob-havosi kerak sizga";

            sendMessage(chatId, sendText);

        } else {

            Pattern compile = Pattern.compile("^\\d$");
            Matcher matcher = compile.matcher(text);

            //Demak nechi kunlikligini so'rayapti
            if (matcher.find()) {

                int days = Integer.parseInt(matcher.group());

                WeatherService weatherService = new WeatherService();

                String city = addressMap.get(chatId);

                WeatherDTO weatherDTO = weatherService.info(city, days);

                String sendText = makeWeatherText(chatId, weatherDTO);

                sendMessage(chatId, sendText);

                //raqam bo'lmasa demak shahar kirityapti
            } else {

                addressMap.put(chatId, text);

            }

        }

    }

    private String makeWeatherText(Long chatId, WeatherDTO weatherDTO) {

        //📍 Tashkent 🌤 Bugungi
        //
        //🌅 Quyosh chiqishi: %s
        //
        //🌄 Quyosh botishi: %s
        //
        //🌡️ Harorat: %s
        //
        //🌬 Shamol: %s
        //
        //💧Namlik: %s
        //
        //
        //📅 26/02
        //
        //🌅 Quyosh chiqishi: %s
        //
        //🌄 Quyosh botishi: %s
        //
        //🌡️ Harorat: %s
        //
        //🌬 Shamol: %s
        //
        //💧Namlik: %s
        //
        //
        //📅 27/02
        //
        //🌅 Quyosh chiqishi: %s
        //
        //🌄 Quyosh botishi: %s
        //
        //🌡️ Harorat: %s
        //
        //🌬 Shamol: %s
        //
        //💧Namlik: %s

        StringBuilder stringBuilder = new StringBuilder();

        String city = weatherDTO.getLocation().getName();

        ForecastDayDTO todayForecastDay = weatherDTO.getForecast().getForecastDay().stream()
                .filter(forecastDayDTO -> forecastDayDTO.getDate().equals(LocalDate.now()))
                .findFirst()
                .orElseThrow();

        String todayWeatherText = makeOneDayWeatherText(todayForecastDay);

        stringBuilder.append("\uD83D\uDCCD ").append(city).append("\uD83C\uDF24 Bugungi\n\n")
                .append(todayWeatherText)
                .append("\n\n");

        DateTimeFormatter dayMonthFormatter = DateTimeFormatter.ofPattern("dd/MM");

        weatherDTO.getForecast().getForecastDay().stream()
                .filter(forecastDayDTO -> !forecastDayDTO.getDate().equals(LocalDate.now()))
                .forEach(forecastDayDTO -> {

                    LocalDate date = forecastDayDTO.getDate();

                    String format = dayMonthFormatter.format(date);

                    String oneDayWeather = makeOneDayWeatherText(forecastDayDTO);

                    stringBuilder.append("\uD83D\uDCC5 ").append(format).append("\n\n")
                            .append(oneDayWeather)
                            .append("\n\n");

                });

        return stringBuilder.toString();
    }

    private String makeOneDayWeatherText(ForecastDayDTO forecastDay) {


        return """
                🌅 Quyosh chiqishi: %s
                
                🌄 Quyosh botishi: %s
                
                🌡️ Harorat: %s
                
                🌬 Shamol: %s
                
                💧Namlik: %s
                """.formatted(
                forecastDay.getAstro().getSunrise(),
                forecastDay.getAstro().getSunset(),
                forecastDay.getDay().getAvgTempC(),
                forecastDay.getDay().getMaxWindKph(),
                forecastDay.getDay().getAvgHumidity()
        );
    }

    private void sendMessage(Long chatId, String sendText) {
        SendMessage sendMessage = new SendMessage(
                chatId.toString(),
                sendText
        );
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getBotUsername() {
        return username;
    }
}
