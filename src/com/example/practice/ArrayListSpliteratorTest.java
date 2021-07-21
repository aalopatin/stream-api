package com.example.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

public class ArrayListSpliteratorTest {
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
        StreamSupport.stream(new ArrayListSpliterator(list), false)
                .forEach(
                        System.out::println
                );
    }
}
