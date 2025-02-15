package uz.pdp.lesson4.functionalinterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

/**
 Created by: Mehrojbek
 DateTime: 11/02/25 21:41
 **/
public class SupplierTest {

    public static void main(String[] args) {

        Supplier<Integer> supplier = () -> new Random().nextInt(20, 50);

        List<Integer> numbers = generateNumbers(10, supplier);

        System.out.println(numbers);


//        Supplier<Employee> generateOneEmployee = () -> {
//
//            Faker faker = new Faker();
//
//            Name name = faker.name();
//
//            Number number = faker.number();
//
//            DateAndTime date = faker.date();
//
//            Bool fakerBool = faker.bool();
//
//            List<String> departments = List.of("HR", "Sales", "Finance", "Management");
//            List<String> positions = List.of("Mutaxasis", "Ishchi", "Rahbar", "Manager");
//
//            long time = date.birthday(17, 35).getTime();
//
//            LocalDate birthDate = new Date(time).toLocalDate();
//
//            Employee employee = new Employee(
//                    name.firstName(),
//                    name.lastName(),
//                    birthDate,
//                    number.numberBetween(400, 1000),
//                    departments.get(number.numberBetween(0, 3)),
//                    positions.get(number.numberBetween(0, 3)),
//                    fakerBool.bool() ? GenderEnum.MALE : GenderEnum.FEMALE,
//                    faker.address().city(),
//                    null
//            );
//            return employee;
//        };

    }

    private static List<Integer> generateNumbers(int count, Supplier<Integer> supplier) {

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < count; i++) {

            Integer num = supplier.get();
            numbers.add(num);

        }

        return numbers;
    }

}
