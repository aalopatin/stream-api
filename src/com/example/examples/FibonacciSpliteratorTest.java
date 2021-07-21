package com.example.examples;

import java.util.stream.StreamSupport;

public class FibonacciSpliteratorTest {
    public static void main(String[] args) {
        StreamSupport.stream(new FibonacciSpliterator(7), true)
                .forEach(
                        System.out::println
                );
    }
}
