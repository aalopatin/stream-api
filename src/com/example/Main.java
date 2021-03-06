package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>() {{
            add("Str0");
            add("Str1");
            add("Str2");
            add("Str3");
            add("Str4");
            add("Str5");
            add("Str6");
            add("Str7");
            add("Str8");
            add("Str9");
        }};

        list
                .stream()
                .parallel()
                .forEach(System.out::println);
    }
}
