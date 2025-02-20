package uz.pdp.lesson6;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 Created by: Mehrojbek
 DateTime: 20/02/25 20:16
 **/
public class MyToListCollector<T> implements Collector<T, List<T>, List<T>> {

    public static <T> MyToListCollector<T> getInstance() {
        return new MyToListCollector<>();
    }

    @Override
    public Supplier<List<T>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<T>, T> accumulator() {
        return List::add;
    }

    @Override
    public BinaryOperator<List<T>> combiner() {
        return null;
    }

    @Override
    public Function<List<T>, List<T>> finisher() {
        return list -> list;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Set.of();
    }
}
