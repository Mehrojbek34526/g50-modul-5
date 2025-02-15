package uz.pdp.lesson3;

import com.github.javafaker.*;
import lombok.Cleanup;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 Created by: Mehrojbek
 DateTime: 06/02/25 20:42
 **/
public class FakerBotService extends TelegramLongPollingBot {
    final String EMPLOYEE = "Xodimlar";
    final String STUDENTS = "Talabalar";
    final String COUNTRIES = "Davlatlar";
    final String CAPITALS = "Poytaxtlar";

    public FakerBotService(String botToken) {
        super(botToken);
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage()) {

            processMessage(update.getMessage());

        }

    }

    private void processMessage(Message message) {

        if (message.hasText()) {

            String text = message.getText();

            if (text.equals("/start")) {

                userStart(message);

            } else if (text.equals(EMPLOYEE)) {

                generateEmployee(message);

            }

        }

    }

    private void generateEmployee(Message message) {

        StringJoiner stringJoiner = generateEmployeesByFaker();

        String fileName = writeFile(stringJoiner);

        SendDocument sendDocument = new SendDocument(
                message.getChatId().toString(),
                new InputFile(new File(fileName))
        );

        try {
            execute(sendDocument);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private static String writeFile(StringJoiner stringJoiner) {
        String fileName = "files/employees.txt";

        try {
            @Cleanup
            Writer writer = new FileWriter(fileName);
            writer.write(stringJoiner.toString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileName;
    }

    private static StringJoiner generateEmployeesByFaker() {
        Faker faker = new Faker();

        Name fakerName = faker.name();

        DateAndTime fakerDate = faker.date();

        Country fakerCountry = faker.country();

        Address fakerAddress = faker.address();

        StringJoiner stringJoiner = new StringJoiner(",\n", "[", "]");

        for (int i = 0; i < 50; i++) {

            LocalDate birthDate = new Date(
                    fakerDate.birthday(18, 35).getTime()
            ).toLocalDate();

            Employee employee = new Employee(
                    fakerName.firstName(),
                    fakerName.lastName(),
                    birthDate,
                    fakerName.bloodGroup(),
                    fakerCountry.name(),
                    fakerAddress.city(),
                    fakerAddress.streetAddress(),
                    fakerName.title()
            );

            stringJoiner.add(employee.toString());
        }
        return stringJoiner;
    }

    private void userStart(Message message) {

        Long chatId = message.getChatId();

        //1. Xodimlar
        //2. Talabalar
        //3. Davlatlar
        //4. Poytaxtlar

        SendMessage sendMessage = new SendMessage(
                chatId.toString(),
                "Xush kelibsiz"
        );

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);

        List<KeyboardRow> rows = new ArrayList<>();
        KeyboardRow row1 = new KeyboardRow();

        row1.add(EMPLOYEE);

        row1.add(STUDENTS);
        rows.add(row1);

        KeyboardRow row2 = new KeyboardRow();


        row2.add(COUNTRIES);

        row2.add(CAPITALS);
        rows.add(row2);

        replyKeyboardMarkup.setKeyboard(rows);

        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    //String token = "1875454739:AAFL1VQadzbEm9WFIHWOGVFwvdMlyebvy6U";
    @Override
    public String getBotUsername() {
        return "ussd_operator_bot";
    }
}
