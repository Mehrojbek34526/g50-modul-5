package uz.pdp.lesson8;

/**
 Created by: Mehrojbek
 DateTime: 20/02/25 21:04
 **/
public class DBTest {

    public static void main(String[] args) {

        Class<DatabaseService> databaseServiceClass = DatabaseService.class;

        DBConnect annotation = databaseServiceClass.getDeclaredAnnotation(DBConnect.class);

        if (annotation != null) {
            String url = annotation.url();
            String username = annotation.username();
            String password = annotation.password();
            System.out.printf("url: %s, username: %s, password: %s\n", url, username, password);
        }

        //1. private field qiymatini o'zgartirish
        //2. 2ta parameter qabul qiluvchi private methodni chaqirish
        //2. 3 ta parameter qabul qiluvchi private constructorni chaqirish

    }

}
