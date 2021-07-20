package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
//    static ConcurrentLinkedQueue<Integer> ints= new ConcurrentLinkedQueue<>();
    public static void main(String[] args) {
//        IntStream.of(120, 410, 85, 32, 314, 12)
//                .filter(x -> x < 300)
//                .map(x -> x + 11)
//                .limit(3)
//                .forEach(System.out::println);
//
//        System.out.println();
//
//        IntStream.of(120, 410, 85, 32, 314, 12)
//                .filter(x -> x < 300)
//                .limit(3)
//                .map(x -> x + 11)
//                .forEach(System.out::println);
//
//        System.out.println();
//
//        IntStream.of(120, 410, 85, 32, 314, 12)
//                .limit(3)
//                .filter(x -> x < 300)
//                .map(x -> x + 11)
//                .forEach(System.out::println);
//
//        System.out.println();
//
//        IntStream.range(0, 1000000)
//                .parallel()
//                .forEach(i -> ints.add(i));
//        System.out.println(ints.size());

//        Stream.Builder<Integer> streamBuider =
//                Stream.<Integer>builder()
//                .add(0)
//                .add(1);
//
//        for (int i = 2; i <= 8; i += 2) {
//            streamBuider.accept(i);
//        }
//
//        streamBuider
//                .add(9)
//                .add(10)
//                .build()
//                .forEach(System.out::println);

//        Stream.of(1, 2, 3, 4, 5, 6)
//                .flatMap(x -> {
//                    switch (x % 3)
//                    {
//                        case 0:
//                            return Stream.of(x, x * x, x * x * 2);
//                        case 1:
//                            return Stream.of(x);
//                        case 2:
//                        default:
//                            return Stream.empty();
//                    }
//                })
//                .forEach(System.out::println);

//        System.out.println(IntStream.range(-2, 2).reduce(10, Integer::sum));

        IntStream.range(0, 10)
                .boxed()
                .collect(Collectors.partitioningBy(i -> i % 2 == 0))
                .entrySet().forEach(System.out::println);

    }
}
