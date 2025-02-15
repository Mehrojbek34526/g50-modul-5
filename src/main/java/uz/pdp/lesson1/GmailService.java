package uz.pdp.lesson1;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Properties;

public class GmailService {

    private static final String username = "mehrojbek970510@gmail.com";
    private static final String password = "igjq lshv hvjj vrou";

    public static void main(String[] args) throws MessagingException {

        var properties = getProperties();
        var session = getSession(properties, username, password);

        var message = new MimeMessage(session);
        var recipient = "mehrojbekdeveloper@gmail.com";

        message.setSubject("This is Subject For Test Message");

//        String content = """
//                <h1 style="color: red; text-align: center; font-style: italic; ">Bu H1 TEXT</h1>
//
//                <h2 style="text-align: center">Bu H2 TEXT</h2>
//
//                <h3 style="text-align: center">Bu H3 TEXT</h3>
//
//                <h4 style="text-align: center">Bu H4 TEXT</h4>
//
//                <h1 style="text-align: center"><a href="https://kun.uz" target="_blank">Bu Kunuz linki</a></h1>
//                """;

        String encodeImage = encodeImage();

        String content = """
                <h1>Salom</h1>
                <img src="data:image/png;base64, %s" />
                """.formatted(encodeImage);

        message.setContent(content,"text/html");

        System.out.println(content);

        message.setFrom(new InternetAddress(username));

        message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

        Transport.send(message);

        System.out.println("Message Sent Successfully");
    }

    private static Properties getProperties() {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        return properties;
    }

    public static String encodeImage(){
        try {
            Base64.Encoder encoder = Base64.getEncoder();
            InputStream inputStream = new FileInputStream("files/image 1.png");
            byte[] bytes = inputStream.readAllBytes();
            byte[] encodedBytes = encoder.encode(bytes);
            return new String(encodedBytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private static Session getSession(Properties properties, String username, String password) {
        return Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
    }
}