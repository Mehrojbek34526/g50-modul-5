package uz.pdp.lesson4;

import com.github.javafaker.Number;
import com.github.javafaker.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

/**
 Created by: Mehrojbek
 DateTime: 11/02/25 19:14
 **/
public class EmployeeGenerateTest {


    public static void main(String[] args) {

        Faker faker = new Faker();
        System.out.println(faker.job().keySkills());

//        List<Employee> employees = generateEmployee();
//        employees.forEach(System.out::println);
//
//        System.out.println("----------------");
//        System.out.println("----------------");

//        List<Employee> salaryFilteredEmployees = filterEmployeeSalaryGreater(employees, 600);
//
//        salaryFilteredEmployees.forEach(System.out::println);


//        System.out.println("----------------");
//        System.out.println("----------------");
////
//        List<Employee> salaryAndGenderFilteredEmployees = filterEmployeeSalaryGreaterAndGender(employees, 400, GenderEnum.FEMALE);
//
//        salaryAndGenderFilteredEmployees.forEach(System.out::println);

//        UniversalFilter<Employee> filter = new GenderFilter(GenderEnum.FEMALE);

//        int num1 = 90;
//
//        final int num2 = num1;
//
//        UniversalFilter<Employee> filter = e -> Objects.equals(e.getGender(), GenderEnum.FEMALE)
//                && e.getSalary() > 500
//                && e.getPosition().equals("Rahbar")
//                && num2 > 67;
//
//        num1 = 78;
//
//        List<Employee> filteredEmployees = universalFilter(employees, filter);
//
//        filteredEmployees.forEach(System.out::println);


//        MyFilter<String, Integer, Boolean> myFilter = (t, r, b) -> t.length() > r && b;
    }

    public static interface MyFilter<T, R, E> {

        boolean convert(T t, R r, E e);

    }

    private static List<Employee> filterEmployeeSalaryGreaterAndGender(List<Employee> employees, int fromSalary, GenderEnum gender) {

        List<Employee> filteredEmployees = new ArrayList<>();

        for (Employee employee : employees) {
            if (employee.getSalary() >= fromSalary && Objects.equals(employee.getGender(), gender)) {
                filteredEmployees.add(employee);
            }
        }

        return filteredEmployees;
    }

    /**
     *
     * @param employees
     * @param salaryFrom
     * @return
     */
    private static List<Employee> filterEmployeeSalaryGreater(List<Employee> employees, int salaryFrom) {

        List<Employee> filteredEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getSalary() >= salaryFrom) {
                filteredEmployees.add(employee);
            }

            if (true){
                System.out.println();
            }
        }

        return filteredEmployees;
    }

    public static List<Employee> universalFilter(List<Employee> employees, UniversalFilter<Employee> universalFilter) {

        List<Employee> filteredEmployees = new ArrayList<>();

        for (Employee employee : employees) {
            if (universalFilter.test(employee)) {
                filteredEmployees.add(employee);
            }
        }

        return filteredEmployees;
    }

    public static List<Employee> universalFilter(List<Employee> employees, Predicate<Employee> universalFilter) {

        List<Employee> filteredEmployees = new ArrayList<>();

        for (Employee employee : employees) {
            if (universalFilter.test(employee)) {
                filteredEmployees.add(employee);
            }
        }

        return filteredEmployees;
    }

    public static List<Employee> generateEmployee() {
        return generateEmployee(20);
    }

    public static List<Employee> generateEmployee(int count) {

        Faker faker = new Faker();

        com.github.javafaker.Address fakerAddress = faker.address();

        Name name = faker.name();

        Number number = faker.number();

        DateAndTime date = faker.date();

        Bool fakerBool = faker.bool();

        Job fakerJob = faker.job();

        List<String> departments = List.of("HR", "Sales", "Finance", "Management");
        List<String> positions = List.of("Mutaxasis", "Ishchi", "Rahbar", "Manager");

        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < count; i++) {

            long time = date.birthday(17, 35).getTime();

            LocalDate birthDate = new Date(time).toLocalDate();

            List<String> skills = new ArrayList<>();
            for (int j = 0; j < number.numberBetween(1, 4); j++) {
                skills.add(fakerJob.keySkills());
            }

            Employee employee = new Employee(
                    name.firstName(),
                    name.lastName(),
                    birthDate,
                    number.numberBetween(400, 1000),
                    departments.get(number.numberBetween(0, 4)),
                    positions.get(number.numberBetween(0, 4)),
                    fakerBool.bool() ? GenderEnum.MALE : GenderEnum.FEMALE,
                    faker.address().city(),
                    null,
                    skills,
                    new Address(
                            fakerAddress.streetName(),
                            fakerAddress.city()
                    )
            );

            employees.add(employee);
        }

        return employees;
    }


    public static class GenderFilter implements UniversalFilter<Employee> {

        private final GenderEnum gender;

        public GenderFilter(GenderEnum gender) {
            this.gender = gender;
        }

        @Override
        public boolean test(Employee employee) {
            return Objects.equals(employee.getGender(), gender);
        }
    }

    public static class SalaryFilter implements UniversalFilter<Employee> {

        private final int salary;

        public SalaryFilter(int salary) {
            this.salary = salary;
        }

        @Override
        public boolean test(Employee employee) {
            return employee.getSalary() >= salary;
        }
    }


}
