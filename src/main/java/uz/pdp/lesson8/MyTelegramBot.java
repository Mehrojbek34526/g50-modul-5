package uz.pdp.lesson8;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.ArrayList;
import java.util.List;

public class MyTelegramBot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().getText().equals("/start")) {
            sendInlineKeyboard(update.getMessage().getChatId());
        }
    }

    private void sendInlineKeyboard(Long chatId) {
        try {
            SendMessage message = new SendMessage();
            message.setChatId(chatId);
            message.setText("Click the button to share this bot!");

            // Create inline button
            InlineKeyboardButton shareButton = new InlineKeyboardButton();
            shareButton.setText("📢 Share Bot");
            shareButton.setSwitchInlineQuery("Check out this bot! @YourBotUsername");

            // Add button to the keyboard
            List<InlineKeyboardButton> row = new ArrayList<>();
            row.add(shareButton);
            List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
            keyboard.add(row);
            InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
            markup.setKeyboard(keyboard);

            message.setReplyMarkup(markup);

            // Send message with inline keyboard
            execute(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "YourBotUsername";  // Replace with your bot's username
    }

    @Override
    public String getBotToken() {
        return "1875454739:AAFL1VQadzbEm9WFIHWOGVFwvdMlyebvy6U";  // Replace with your bot's token
    }

    public static void main(String[] args) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new MyTelegramBot());
            System.out.println("Bot started!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
