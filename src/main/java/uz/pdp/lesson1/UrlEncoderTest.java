package uz.pdp.lesson1;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 Created by: Mehrojbek
 DateTime: 01/02/25 21:42
 **/
public class UrlEncoderTest {

    public static void main(String[] args) {

//        urlEncodeAndDecode();

        String encode = URLEncoder.encode("1. Spring boot framework.pdf");
        System.out.println(encode);

    }

    private static void urlEncodeAndDecode() {
        String encodedUrl = URLEncoder.encode("google.com 54565 %$#,^,=");
        System.out.println(encodedUrl);

        String decode = URLDecoder.decode(encodedUrl);
        System.out.println(decode);
    }

}
