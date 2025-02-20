package uz.pdp.lesson8;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DBConnect {

    String url() default "jdbc:postgresql://localhost:5432/postgres";

    String username();

    String password();

}
