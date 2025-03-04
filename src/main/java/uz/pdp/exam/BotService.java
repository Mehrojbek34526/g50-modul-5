package uz.pdp.exam;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
import uz.pdp.lesson4.GenderEnum;
import uz.pdp.lesson7.LocalDateGsonConverter;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 Created by: Mehrojbek
 DateTime: 04/03/25 19:05
 **/
public class BotService extends TelegramLongPollingBot {

    private Map<Long, StateEnum> userStateMap = new HashMap<>();
    private Map<Long, Employee> employees = new HashMap<>();

    public BotService(String botToken) {
        super(botToken);
    }

    @Override
    public void onUpdateReceived(Update update) {

        try {
            if (update.hasMessage()) {
                processMessage(update.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void processMessage(Message message) {

        if (message.hasText()) {
            processText(message);
        }

    }

    private void processText(Message message) {

        String text = message.getText();

        if (text.equals("/start")) {

            home(message);

        } else if (text.equals(BotConstants.ADD_EMPLOYEE)) {

            sendMsg(message.getChatId(), "Xodim ismini kiriting");
            userStateMap.put(message.getChatId(), StateEnum.WRITING_FIRST_NAME);

        } else if (text.equals(BotConstants.DOWNLOAD_JSON)) {

            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDate.class, new LocalDateGsonConverter())
                    .setPrettyPrinting()
                    .create();

            Collection<Employee> values = employees.values();

            String json = gson.toJson(values);

            try {
                String fileName = "employees.json";

                @Cleanup
                FileWriter fileWriter = new FileWriter(fileName);
                fileWriter.write(json);
                fileWriter.close();

                SendDocument sendDocument = new SendDocument(
                        message.getChatId().toString(),
                        new InputFile(new File(fileName))
                );

                execute(sendDocument);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        } else {

            StateEnum stateEnum = userStateMap.get(message.getChatId());
            if (stateEnum == null) {
                home(message);
                return;
            }

            if (stateEnum == StateEnum.WRITING_FIRST_NAME) {

                Employee employee = employees.getOrDefault(message.getChatId(), new Employee());
                employee.setFirstName(text);
                employees.put(message.getChatId(), employee);

                sendMsg(message.getChatId(), "Xodim familiyasini kiriting");
                userStateMap.put(message.getChatId(), StateEnum.WRITING_LAST_NAME);

            } else if (stateEnum == StateEnum.WRITING_LAST_NAME) {

                Employee employee = employees.getOrDefault(message.getChatId(), new Employee());
                employee.setLastName(text);
                employees.put(message.getChatId(), employee);
                sendMsg(message.getChatId(), "Xodim jinsini kiriting: (Male, Female)");

                userStateMap.put(message.getChatId(), StateEnum.WRITING_GENDER);

            } else if (stateEnum == StateEnum.WRITING_GENDER) {
                Employee employee = employees.getOrDefault(message.getChatId(), new Employee());
                employees.put(message.getChatId(), employee);

                Optional<GenderEnum> optionalGenderEnum = Arrays.stream(GenderEnum.values())
                        .filter(genderEnum -> text.equalsIgnoreCase(genderEnum.name()))
                        .findFirst();

                if (optionalGenderEnum.isEmpty()) {
                    sendMsg(message.getChatId(), "Xato ma'lumot kiritildi. Namuna: Male/Female");
                    return;
                }

                GenderEnum gender = optionalGenderEnum.get();
                employee.setGender(gender);

                sendMsg(message.getChatId(), "Tug'ilgan yilini kiriting: 1998-02-09");

                userStateMap.put(message.getChatId(), StateEnum.WRITING_BIRTH_DATE);

            } else if (stateEnum == StateEnum.WRITING_BIRTH_DATE) {

                Employee employee = employees.getOrDefault(message.getChatId(), new Employee());
                employees.put(message.getChatId(), employee);

                try {
                    LocalDate birthDate = LocalDate.parse(text);

                    employee.setBirthDate(birthDate);

                    sendMsg(message.getChatId(), "Xodim hobbiylarini kiriting. Namuna: Futbol, Voleybol, Shaxmat");
                    userStateMap.put(message.getChatId(), StateEnum.WRITING_HOBBIES);

                } catch (Exception e) {
                    sendMsg(message.getChatId(), "Xato ma'lumot kiritildi. Namuna: 1998-02-09");
                }


            } else if (stateEnum == StateEnum.WRITING_HOBBIES) {

                Employee employee = employees.getOrDefault(message.getChatId(), new Employee());
                employees.put(message.getChatId(), employee);

                List<String> hobbies = Arrays.stream(text.split(","))
                        .collect(Collectors.toList());

                employee.setHobbies(hobbies);
            }

        }

    }

    private void home(Message message) {

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);

        List<KeyboardRow> rows = new ArrayList<>();

        KeyboardRow viewRow = new KeyboardRow();
        viewRow.add(BotConstants.VIEW_EMPLOYEE);
        rows.add(viewRow);

        KeyboardRow addRow = new KeyboardRow();
        addRow.add(BotConstants.ADD_EMPLOYEE);
        rows.add(addRow);

        KeyboardRow deleteRow = new KeyboardRow();
        deleteRow.add(BotConstants.DELETE_EMPLOYEE);
        rows.add(deleteRow);

        KeyboardRow downloadJsonRow = new KeyboardRow();
        downloadJsonRow.add(BotConstants.DOWNLOAD_JSON);
        rows.add(downloadJsonRow);

        replyKeyboardMarkup.setKeyboard(rows);

        Long chatId = message.getChatId();
        String text = "Xush kelibsiz";
        sendMsg(chatId, text, replyKeyboardMarkup);
    }

    private void sendMsg(Long chatId, String text, ReplyKeyboardMarkup replyKeyboardMarkup) {
        try {
            SendMessage sendMessage = new SendMessage(
                    chatId.toString(),
                    text
            );
            sendMessage.setReplyMarkup(replyKeyboardMarkup);
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void sendMsg(Long chatId, String text) {
        try {
            SendMessage sendMessage = new SendMessage(
                    chatId.toString(),
                    text
            );
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String getBotUsername() {
        return "test";
    }
}
