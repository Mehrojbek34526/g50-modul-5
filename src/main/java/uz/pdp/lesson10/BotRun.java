package uz.pdp.lesson10;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

/**
 Created by: Mehrojbek
 DateTime: 25/02/25 19:42
 **/
public class BotRun {

    public static void main(String[] args) {

        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);

            Class<BotService> botServiceClass = BotService.class;

            TgBotCredentialAnnotation annotation = botServiceClass.getDeclaredAnnotation(TgBotCredentialAnnotation.class);

            String username = annotation.username();
            String token = annotation.token();

            telegramBotsApi.registerBot(new BotService(token, username));

        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

}
