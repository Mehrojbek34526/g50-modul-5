package uz.pdp.lesson10.bot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

/**
 Created by: Mehrojbek
 DateTime: 25/02/25 20:52
 **/
public class MainForWeatherBot {

    public static void main(String[] args) {

        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);

            String token = "1875454739:AAFL1VQadzbEm9WFIHWOGVFwvdMlyebvy6U";
            String username = "ussd_operator_bot";

            WeatherBotService botService = new WeatherBotService(token, username);

            telegramBotsApi.registerBot(botService);

        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

}
