package uz.pdp.lesson3;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

/**
 Created by: Mehrojbek
 DateTime: 06/02/25 20:59
 **/
public class FakerBotStart {

    public static void main(String[] args) {

        try {
            String token = "1875454739:AAFL1VQadzbEm9WFIHWOGVFwvdMlyebvy6U";

            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);

            telegramBotsApi.registerBot(new FakerBotService(token));

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

}
