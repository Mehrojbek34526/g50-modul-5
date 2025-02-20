package uz.pdp.lesson6;

import uz.pdp.lesson4.Employee;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 Created by: Mehrojbek
 DateTime: 20/02/25 19:22
 **/
public class ToJsonCollector implements Collector<Employee, StringBuilder, String> {

    public static ToJsonCollector getInstance() {
        return new ToJsonCollector();
    }

    @Override
    public Supplier<StringBuilder> supplier() {
        return StringBuilder::new;
    }

    @Override
    public BiConsumer<StringBuilder, Employee> accumulator() {
        return (stringBuilder, employee) -> {

            if (!stringBuilder.isEmpty()) {
                stringBuilder.append(",\n\n");
            }
            stringBuilder.append(employee.toJson());
        };
    }

    @Override
    public BinaryOperator<StringBuilder> combiner() {
        return null;
//        return (stringBuilder1, stringBuilder2) ->{
//            StringBuilder result = stringBuilder1.append(",").append(stringBuilder2);
//            System.out.println(result);
//            return result;
//        };
//        return StringBuilder::append;
    }

    @Override
    public Function<StringBuilder, String> finisher() {
        return stringBuilder -> "[\n" + stringBuilder.toString() + "\n]";
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Set.of();
    }
}
