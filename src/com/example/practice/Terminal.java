package com.example.practice;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.BiFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Terminal {
    public static void main(String[] args) {
        IntStream.range(0, 10)
                .parallel()
                .forEach(x -> System.out.format("%s, ", x));

        System.out.println();

        IntStream.range(0, 10)
                .parallel()
                .forEachOrdered(x -> System.out.format("%s, ", x));

        System.out.println();

        Integer sum = IntStream.range(0, 5)
                .reduce(10, Integer::sum);

        System.out.println(sum);

        String result = Stream.of("str1", "str2", "str3", "str4", "str5", "str6", "str7", "str8", "str9")
                .parallel()
                .reduce("",
                        (s, s2) -> (s + " " + s2).trim()
                );

        System.out.println(result);

        OptionalInt max = IntStream.range(0, 5)
                .reduce((left, right) -> Integer.compare(left, right) > 0 ? left : right);

        System.out.println(max.orElse(Integer.MAX_VALUE));

        OptionalInt max1 = IntStream.range(0, 5)
                .reduce((left, right) -> Integer.max(left, right));

        System.out.println(max1.orElse(Integer.MAX_VALUE));

    }
}
