package uz.pdp.lesson3;

import com.github.javafaker.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Locale;

/**
 Created by: Mehrojbek
 DateTime: 06/02/25 19:25
 **/
public class FakerTest {

    public static void main(String[] args) {

//        Locale locale = Locale.FRANCE;
        Locale locale = Locale.ENGLISH;
//        Locale locale = Locale.forLanguageTag("uz");

        Faker faker = new Faker(locale);



//        dateTimeTest(faker);

//        pokemonTest(faker);

//        harryPotterTest(faker);

//        ancientTest(faker);

//        countryTest(faker);

//        colorTest(faker);

//        Avatar avatar = faker.avatar();
//        for (int i = 0; i < 10; i++) {
//
//            System.out.println("avatar.image() = " + avatar.image());
//
//        }

//        artistTest(faker);

//        addressTest(faker);

//        animalTest(faker);

//        phoneNumbertest(faker);

//        nameTest(faker);

    }

    private static void dateTimeTest(Faker faker) {
        DateAndTime date = faker.date();
        for (int i = 0; i < 10; i++) {

//            Date birthday = date.birthday();
//
//            LocalDate localDate = new java.sql.Date(birthday.getTime()).toLocalDate();
//
//            System.out.println("date.birthday() = " + localDate);

//            LocalDate localDate = new Date(date.birthday(15, 45).getTime()).toLocalDate();
//            System.out.println(localDate);
        }
    }

    private static void pokemonTest(Faker faker) {
        Pokemon pokemon = faker.pokemon();
        for (int i = 0; i < 10; i++) {

            System.out.println("pokemon.name() = " + pokemon.name());

        }
    }

    private static void harryPotterTest(Faker faker) {
        HarryPotter harryPotter = faker.harryPotter();

        for (int i = 0; i < 10; i++) {
//            System.out.println("harryPotter.character() = " + harryPotter.character());
//            System.out.println("harryPotter.book() = " + harryPotter.book());
//            System.out.println("harryPotter.quote() = " + harryPotter.quote());
        }
    }

    private static void ancientTest(Faker faker) {
        Ancient ancient = faker.ancient();
        System.out.println("ancient.titan() = " + ancient.titan());
    }

    private static void countryTest(Faker faker) {
        Country country = faker.country();

        for (int i = 0; i < 10; i++) {
//            System.out.println("country.capital() = " + country.capital());
//            System.out.println("country.countryCode3() = " + country.countryCode3());
//            System.out.println("country.name() = " + country.name());
//            System.out.println("country.currency() = " + country.currency());
//            System.out.println("country.flag() = " + country.flag());
        }
    }

    private static void colorTest(Faker faker) {
        Color color = faker.color();
        for (int i = 0; i < 10; i++) {
//            System.out.println("color.hex() = " + color.hex());
//            System.out.println("color.name() = " + color.name());
        }
    }

    private static void artistTest(Faker faker) {
        Artist artist = faker.artist();

        for (int i = 0; i < 10; i++) {

            System.out.println("artist.name() = " + artist.name());

        }
    }

    private static void addressTest(Faker faker) {
        Address address = faker.address();

        for (int i = 0; i < 10; i++) {
//            System.out.println("address.country() = " + address.country());
//            System.out.println("address.firstName() = " + address.firstName());
//            System.out.println("address.countryCode() = " + address.countryCode());
//            System.out.println("address.zipCode() = " + address.zipCode());
//            System.out.println("address.city() = " + address.city());
//            System.out.println("address.cityName() = " + address.cityName());
//            System.out.println("address.cityPrefix() = " + address.cityPrefix());
//            System.out.println("address.citySuffix() = " + address.citySuffix());
//            System.out.println("address.fullAddress() = " + address.fullAddress());
//            System.out.println("address.streetName() = " + address.streetName());
        }
    }

    private static void animalTest(Faker faker) {
        Animal animal = faker.animal();

        for (int i = 0; i < 10; i++) {
            System.out.println("animal.name() = " + animal.name());
        }
    }

    private static void phoneNumbertest(Faker faker) {
        PhoneNumber phoneNumber = faker.phoneNumber();

        for (int i = 0; i < 10; i++) {
//            System.out.println("phoneNumber.cellPhone() = " + phoneNumber.cellPhone());
//            System.out.println("phoneNumber.phoneNumber() = " + phoneNumber.phoneNumber());
//            System.out.println("phoneNumber.subscriberNumber() = " + phoneNumber.subscriberNumber());
//            System.out.println("phoneNumber.subscriberNumber() = " + phoneNumber.subscriberNumber(3));
            System.out.println("phoneNumber.extension() = " + phoneNumber.extension());
        }
    }

    private static void nameTest(Faker faker) {
        Name name = faker.name();

        for (int i = 0; i < 20; i++) {

            System.out.println("name.firstName() = " + name.firstName());
//            System.out.println("name.lastName() = " + name.lastName());
//            System.out.println("name.fullName() = " + name.fullName());
//            System.out.println("name.nameWithMiddle() = " + name.nameWithMiddle());
//            System.out.println("name.bloodGroup() = " + name.bloodGroup());
//            System.out.println("name.username() = " + name.username());
//            System.out.println("name.prefix() = " + name.prefix());
//            System.out.println("name.suffix() = " + name.suffix());
//            System.out.println("name.title() = " + name.title());

        }
    }

}
