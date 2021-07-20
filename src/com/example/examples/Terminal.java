package com.example.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Terminal {
    public static void main(String[] args) {
        Stream.of(120, 410, 85, 32, 314, 12)
                .forEach(x -> System.out.format("%s, ", x));
        // 120, 410, 85, 32, 314, 12

        System.out.println("\n");

        IntStream.range(0, 100000)
                .parallel()
                .filter(x -> x % 10000 == 0)
                .map(x -> x / 10000)
                .forEach(x -> System.out.format("%s, ", x));
        // 5, 6, 7, 3, 4, 8, 0, 9, 1, 2

        System.out.println("\n");

        IntStream.range(0, 100000)
                .parallel()
                .filter(x -> x % 10000 == 0)
                .map(x -> x / 10000)
                .forEachOrdered(x -> System.out.format("%s, ", x));
        // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9

        System.out.println("\n");

        //long count()
        //Возвращает количество элементов стрима.
        long count = IntStream.range(0, 10)
                .flatMap(x -> IntStream.range(0, x))
                .count();
        System.out.println(count);
        // 45

        System.out.println();

        System.out.println(
                IntStream.rangeClosed(-3, 6)
                        .count()
        );
        // 10

        System.out.println();

        System.out.println(
                Stream.of(0, 2, 9, 13, 5, 11)
                        .map(x -> x * 2)
                        .filter(x -> x % 2 == 1)
                        .count()
        );
        // 0


        System.out.println();

        //R collect(Collector collector)
        List<Integer> list = Stream.of(1, 2, 3)
                .collect(Collectors.toList());
        System.out.println(list);
        // list: [1, 2, 3]

        System.out.println();

        String s = Stream.of(1, 2, 3)
                .map(String::valueOf)
                .collect(Collectors.joining("-", "<", ">"));
        System.out.println(s);
        // s: "<1-2-3>"

        System.out.println();

        //R collect(Supplier supplier, BiConsumer accumulator, BiConsumer combiner)
        List<String> list1 = Stream.of("a", "b", "c", "d")
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println(list1);
        // list: ["a", "b", "c", "d"]

        System.out.println();

        Object[] objects = Stream.of("a", "b", "c", "d")
                .toArray();
        System.out.println(objects);

        String[] strings = Stream.of("a", "b", "c", "d")
                .toArray(String[]::new);
        System.out.println(strings);
        // elements: ["a", "b", "c", "d"]

        List<String> elements = Stream.of("a", "b", "c", "d")
                .map(String::toUpperCase)
                .toList();
        // elements: ["A", "B", "C", "D"]

        System.out.println();

        int sum = Stream.of(1, 2, 3, 4, 5)
                .reduce(10, (acc, x) -> acc + x);
        // sum: 25

        System.out.println();

        Optional<Integer> result = Stream.<Integer>empty()
                .reduce((acc, x) -> acc + x);
        System.out.println(result.isPresent());
        // false

        Optional<Integer> sum1 = Stream.of(1, 2, 3, 4, 5)
                .reduce((acc, x) -> acc + x);
        System.out.println(sum1.get());
        // 15

        System.out.println();

        int min = Stream.of(20, 11, 45, 78, 13)
                .min(Integer::compare).get();
        // min: 11

        int max = Stream.of(20, 11, 45, 78, 13)
                .max(Integer::compare).get();
        // max: 78


        System.out.println();

        int anySeq = IntStream.range(4, 65536)
                .findAny()
                .getAsInt();
        // anySeq: 4

        int firstSeq = IntStream.range(4, 65536)
                .findFirst()
                .getAsInt();
        // firstSeq: 4

        int anyParallel = IntStream.range(4, 65536)
                .parallel()
                .findAny()
                .getAsInt();
        // anyParallel: 32770

        int firstParallel = IntStream.range(4, 65536)
                .parallel()
                .findFirst()
                .getAsInt();
        // firstParallel: 4

        System.out.println();

        LongSummaryStatistics stats = LongStream.range(2, 16)
                .summaryStatistics();
        System.out.format("  count: %d%n", stats.getCount());
        System.out.format("    sum: %d%n", stats.getSum());
        System.out.format("average: %.1f%n", stats.getAverage());
        System.out.format("    min: %d%n", stats.getMin());
        System.out.format("    max: %d%n", stats.getMax());
        //   count: 14
        //     sum: 119
        // average: 8,5
        //     min: 2
        //     max: 15

    }
}
