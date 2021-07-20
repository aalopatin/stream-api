package com.example.practice;

import java.util.stream.Stream;

public class Sources {
    public static void main(String[] args) {
        //of(T... values)
        Stream.of(1.0, 2.0, 3.0, 4.0, 5.0).forEach(aDouble -> System.out.printf(" %1.1f", aDouble));
    }
}
