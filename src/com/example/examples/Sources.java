package com.example.examples;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Sources {
    public static void main(String[] args) {
        Stream.empty().forEach(System.out::println);
        // Вывода нет

        System.out.println();

        Arrays.asList(1, 2, 3).stream().forEach(System.out::println);
        Stream.of(1, 2, 3).forEach(System.out::println);

        System.out.println();

        String str = Math.random() > 0.5 ? "I'm feeling lucky" : null;
        Stream.ofNullable(str).forEach(System.out::println);

        System.out.println();

        Stream.generate(() -> 6).limit(6).forEach(System.out::println);
        // 6, 6, 6, 6, 6, 6

        System.out.println();

        Stream.iterate(2, x -> x + 6).limit(6).forEach(System.out::println);
        // 2, 8, 14, 20, 26, 32

        System.out.println();

        Stream.iterate(1, x -> x * 2)
                .limit(6)
                .forEach(System.out::println);
        // 1, 2, 4, 8, 16, 32

        System.out.println();

        Stream.iterate(2, x -> x < 25, x -> x + 6).forEach(System.out::println);
        // 2, 8, 14, 20

        Stream.iterate(4, x -> x < 100, x -> x * 4).forEach(System.out::println);
        //4, 16, 64

        Stream.concat(
                Stream.of(1, 2, 3),
                Stream.of(4, 5, 6))
                .forEach(System.out::println);
        // 1, 2, 3, 4, 5, 6

        Stream.concat(
                Stream.of(10),
                Stream.of(4, 16))
                .forEach(System.out::println);
        // 10, 4, 16

        Stream.Builder<Integer> streamBuider = Stream.<Integer>builder()
                .add(0)
                .add(1);
        for (int i = 2; i <= 8; i += 2) {
            streamBuider.accept(i);
        }
        streamBuider
                .add(9)
                .add(10)
                .build()
                .forEach(System.out::println);
        // 0, 1, 2, 4, 6, 8, 9, 10

        IntStream.range(0, 10).forEach(System.out::println);
        // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9

        LongStream.range(-10L, -5L).forEach(System.out::println);
        // -10, -9, -8, -7, -6

        IntStream.rangeClosed(0, 5).forEach(System.out::println);
        // 0, 1, 2, 3, 4, 5

        LongStream.range(-8L, -5L).forEach(System.out::println);
        // -8, -7, -6, -5

    }
}
