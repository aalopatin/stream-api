package com.example.examples;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Intermediate {
    public static void main(String[] args) {
        Stream.of(1, 2, 3)
                .filter(x -> x == 10)
                .forEach(System.out::print);
        // Вывода нет, так как после фильтрации стрим станет пустым

        System.out.println();

        Stream.of(120, 410, 85, 32, 314, 12)
                .filter(x -> x > 100)
                .forEach(System.out::println);
        // 120, 410, 314

        System.out.println();

        IntStream.range(2, 9)
                .filter(x -> x % 3 == 0)
                .forEach(System.out::println);
        // 3, 6

        System.out.println();

        Stream.of("3", "4", "5")
                .map(Integer::parseInt)
                .map(x -> x + 10)
                .forEach(System.out::println);
        // 13, 14, 15

        System.out.println();

        Stream.of(120, 410, 85, 32, 314, 12)
                .map(x -> x + 11)
                .forEach(System.out::println);
        // 131, 421, 96, 43, 325, 23

        System.out.println();

        Stream.of("10", "11", "32")
                        .map(x -> Integer.parseInt(x, 16))
                        .forEach(System.out::println);
        //16, 17, 50

        System.out.println();

        Stream.of(2, 3, 0, 1, 3)
                .flatMapToInt(x -> IntStream.range(0,x))
                .forEach(System.out::println);
        // 0, 1, 0, 1, 2, 0, 0, 1, 2

        System.out.println();

        Stream.of(1, 2, 3, 4, 5, 6)
                .flatMap(x -> {
                    switch (x % 3) {
                        case 0:
                            return Stream.of(x, x * x, x * x * 2);
                        case 1:
                            return Stream.of(x);
                        case 2:
                        default:
                            return Stream.empty();
                    }
                }).forEach(System.out::println);
        // 1, 3, 9, 18, 4, 6, 36, 72

        System.out.println();

        Stream.of(1, 2, 3, 4, 5, 6)
                .flatMap(x -> {
                    if (x % 2 == 0) {
                        return Stream.of(-x, x);
                    }
                    return Stream.empty();
                })
                .forEach(System.out::println);
        // -2, 2, -4, 4, -6, 6

        System.out.println();

        Stream.of(1, 2, 3, 4, 5, 6)
                .mapMulti((x, consumer) -> {
                    if (x % 2 == 0) {
                        consumer.accept(-x);
                        consumer.accept(x);
                    }
                })
                .forEach(System.out::println);
        // -2, 2, -4, 4, -6, 6

        System.out.println();

        Stream.of(120, 410, 85, 32, 314, 12)
                .limit(4)
                .forEach(System.out::println);
        // 120, 410, 85, 32

        System.out.println();

        Stream.of(120, 410, 85, 32, 314, 12)
                .limit(2)
                .limit(5)
                .forEach(System.out::println);
        // 120, 410

        Stream.of(19)
                .limit(0)
                .forEach(System.out::println);
        // Вывода нет

        System.out.println();

        Stream.of(5, 10)
                .skip(40)
                .forEach(System.out::println);
        // Вывода нет

        Stream.of(120, 410, 85, 32, 314, 12)
                .skip(2)
                .forEach(System.out::println);
        // 85, 32, 314, 12

        System.out.println();

        IntStream.range(0, 10)
                .limit(5)
                .skip(3)
                .forEach(System.out::println);
        //3, 4

        IntStream.range(0, 10)
                .skip(5)
                .limit(3)
                .skip(1)
                .forEach(System.out::println);
        //6, 7

        System.out.println();

        IntStream.range(0, 100000000)
                .sorted()
                .limit(3)
                .forEach(System.out::println);
        // 0, 1, 2

//        IntStream.concat(
//                IntStream.range(0, 100000000),
//                IntStream.of(-1, -2))
//                .sorted()
//                .limit(3)
//                .forEach(System.out::println);
//        // Exception in thread "main" java.lang.OutOfMemoryError: Java heap space

        Stream.of(120, 410, 85, 32, 314, 12)
                .sorted()
                .forEach(System.out::println);
        // 12, 32, 85, 120, 314, 410


        System.out.println();

        Stream.of(2, 1, 8, 1, 3, 2)
                .distinct()
                .forEach(System.out::println);
        // 2, 1, 8, 3

        System.out.println();

        IntStream.concat(
                IntStream.range(2, 5),
                IntStream.range(0, 4))
                .distinct()
                .forEach(System.out::println);
        //2, 3, 4, 0, 1

        System.out.println();

        Stream.of(0, 3, 0, 0, 5)
                .peek(x -> System.out.format("before distinct: %d%n", x))
                .distinct()
                .peek(x -> System.out.format("after distinct: %d%n", x))
                .map(x -> x * x)
                .forEach(x -> System.out.format("after map: %d%n", x));
        // before distinct: 0
        // after distinct: 0
        // after map: 0
        // before distinct: 3
        // after distinct: 3
        // after map: 9
        // before distinct: 1
        // after distinct: 1
        // after map: 1
        // before distinct: 5
        // before distinct: 0
        // before distinct: 5
        // after distinct: 5
        // after map: 25

        System.out.println();

        Stream.of(1, 2, 3, 4, 2, 5)
                .takeWhile(x -> x < 3)
                .forEach(System.out::println);
        // 1, 2

    }



}
