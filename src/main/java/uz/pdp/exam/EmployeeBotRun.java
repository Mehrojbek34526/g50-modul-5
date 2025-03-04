package uz.pdp.exam;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

/**
 Created by: Mehrojbek
 DateTime: 04/03/25 19:35
 **/
public class EmployeeBotRun {

    public static void main(String[] args) {

        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new BotService("1875454739:AAFL1VQadzbEm9WFIHWOGVFwvdMlyebvy6U"));
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

}
