package com.example.examples;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsExamples {
    public static void main(String[] args) {
//        Map<Integer, Integer> map1 = Stream.of(1, 2, 3, 4, 5)
//                .collect(Collectors.toMap(
//                        Function.identity(),
//                        Function.identity()
//                ));
//        // {1=1, 2=2, 3=3, 4=4, 5=5}
//
//        Map<Integer, String> map2 = Stream.of(1, 2, 3)
//                .collect(Collectors.toMap(
//                        Function.identity(),
//                        i -> String.format("%d * 2 = %d", i, i * 2)
//                ));
//        // {1="1 * 2 = 2", 2="2 * 2 = 4", 3="3 * 2 = 6"}
//
//        Map<Character, String> map3 = Stream.of(50, 54, 55)
//                .collect(Collectors.toMap(
//                        i -> (char) i.intValue(),
//                        i -> String.format("<%d>", i)
//                ));
//        // {'2'="<50>", '6'="<54>", '7'="<55>"}
//
//        Map<Integer, String> map4 = Stream.of(50, 55, 69, 20, 19, 52)
//                .collect(Collectors.toMap(
//                        i -> i % 5,
//                        i -> String.format("<%d>", i),
//                        (a, b) -> String.join(", ", a, b)
//                ));
//        // {0="<50>, <55>, <20>", 2="<52>", 4="<64>, <19>"}
//
//        Map<Integer, List<String>> map5 = Stream.of(
//                "ab", "c", "def", "gh", "ijk", "l", "mnop")
//                .collect(Collectors.groupingBy(String::length));
//        map5.entrySet().forEach(System.out::println);
//        // 1=[c, l]
//        // 2=[ab, gh]
//        // 3=[def, ijk]
//        // 4=[mnop]
//
//        Map<Integer, String> map6 = Stream.of(
//                "ab", "c", "def", "gh", "ijk", "l", "mnop")
//                .collect(Collectors.groupingBy(
//                        String::length,
//                        Collectors.mapping(
//                                String::toUpperCase,
//                                Collectors.joining())
//                ));
//        map6.entrySet().forEach(System.out::println);
//        // 1=CL
//        // 2=ABGH
//        // 3=DEFIJK
//        // 4=MNOP
//
//        Map<Integer, List<String>> map7 = Stream.of(
//                "ab", "c", "def", "gh", "ijk", "l", "mnop")
//                .collect(Collectors.groupingBy(
//                        String::length,
//                        LinkedHashMap::new,
//                        Collectors.mapping(
//                                String::toUpperCase,
//                                Collectors.toList())
//                ));
//        map7.entrySet().forEach(System.out::println);
//        // 2=[AB, GH]
//        // 1=[C, L]
//        // 3=[DEF, IJK]
//        // 4=[MNOP]

        final Set<Integer> elements = new HashSet<>();
        final Map<Boolean, List<Integer>> listMap =
                Stream.of(1, 2, 3, 1, 9, 2, 5, 3, 4, 8, 2).collect(Collectors.partitioningBy(elements::add));

        System.out.println(elements);
        System.out.println(listMap);
//        (isUnique, list) -> System.out.format("%s: %s%n", isUnique ? "unique" : "repetitive", list)


    }
}
