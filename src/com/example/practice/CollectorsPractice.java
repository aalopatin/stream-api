package com.example.practice;

import javax.management.monitor.StringMonitor;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsPractice {
    public static void main(String[] args) {
        Map<String, Integer> collect = Stream.of("String", "String1", "Str", "str777")
                .collect(Collectors.toMap(Function.identity(), s -> s.length()));

        System.out.println();

        Map<Integer, Set<String>> map7 = Stream.of(
                "ab", "c", "def", "gh", "ijk", "l", "mnop", "l")
                .collect(Collectors.groupingBy(String::length, Collectors.toSet()));
        map7.entrySet().forEach(System.out::println);

        Map<Integer, List<String>> map8 = Stream.of(
                "ab", "c", "def", "gh", "ijk", "l", "mnop", "l")
                .collect(Collectors.groupingBy(String::length, Collectors.toList()));
        map8.entrySet().forEach(System.out::println);

    }
}
