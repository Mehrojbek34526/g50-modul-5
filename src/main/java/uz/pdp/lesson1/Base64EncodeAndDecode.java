package uz.pdp.lesson1;

import java.io.*;
import java.util.Base64;

/**
 Created by: Mehrojbek
 DateTime: 01/02/25 20:56
 **/
public class Base64EncodeAndDecode {

    public static void main(String[] args) throws IOException {

        encode();

//        decode();

    }



    private static void decode() throws IOException {
        Base64.Decoder decoder = Base64.getDecoder();

        InputStream inputStream = new FileInputStream("files/encoded.txt");

        byte[] bytes = inputStream.readAllBytes();

        byte[] decodedBytes = decoder.decode(bytes);

        OutputStream outputStream = new FileOutputStream("files/imageDeceode.png");
        outputStream.write(decodedBytes);
    }

    private static void encode() throws IOException {
        Base64.Encoder encoder = Base64.getEncoder();

        InputStream inputStream = new FileInputStream(new File("files/image 1.png"));

        byte[] bytes = inputStream.readAllBytes();

        byte[] encode = encoder.encode(bytes);
        String encodeStr = new String(encode);

        Writer writer = new FileWriter("files/encoded.txt");
        writer.write(encodeStr);
    }

}
