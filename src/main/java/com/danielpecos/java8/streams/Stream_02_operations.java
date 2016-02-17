package com.danielpecos.java8.streams;

import java.util.stream.IntStream;

import static java.util.stream.IntStream.range;

public class Stream_02_operations {

    public void streamMap() {
        IntStream ints = range(0, Integer.MAX_VALUE);
        ints.map((i) -> i * 2);
    }

    public void streamFilter() {
        IntStream ints = range(0, Integer.MAX_VALUE);
        ints.filter((i) -> i % 2 == 0);
    }

    public void streamReduce() {
        IntStream ints = range(0, Integer.MAX_VALUE);
        ints.reduce((i, j) -> i + j);
    }

    public static void streamFlatMap() {
        range(0, 3).mapToObj((i) -> range(0, i * 2)).forEach((stream) -> {
            stream.forEach(System.out::print);
            System.out.println();
        });

        System.out.println("---");

        range(0, 3).flatMap((i) -> range(0, i * 2)).forEach(System.out::print);
    }

    public static void main(String[] args) {
        streamFlatMap();
    }
}
