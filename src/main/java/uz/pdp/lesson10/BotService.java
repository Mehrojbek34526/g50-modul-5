package uz.pdp.lesson10;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 Created by: Mehrojbek
 DateTime: 25/02/25 19:39
 **/

@TgBotCredentialAnnotation(token = "1875454739:AAFL1VQadzbEm9WFIHWOGVFwvdMlyebvy6U", username = "mybot")
public class BotService extends TelegramLongPollingBot {

    private final String username;

    public BotService(String botToken, String username) {
        super(botToken);
        this.username = username;
    }

    @Override
    public void onUpdateReceived(Update update) {

        System.out.println(update.getMessage().getText());

    }

    @Override
    public String getBotUsername() {
        return username;
    }
}
