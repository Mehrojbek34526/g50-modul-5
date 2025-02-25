package uz.pdp.lesson10;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 Created by: Mehrojbek
 DateTime: 25/02/25 19:38
 **/
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface TgBotCredentialAnnotation {

    String username() default "yourbot";

    String token();

}
