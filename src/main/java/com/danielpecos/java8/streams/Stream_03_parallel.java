package com.danielpecos.java8.streams;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.range;

public class Stream_03_parallel {

    public static final int NUMBERS_TO_PROCESS = 1_000_000_000;

    public static void main(String[] args) {
        IntStream ints1 = range(0, Integer.MAX_VALUE);
        IntStream ints2 = range(0, Integer.MAX_VALUE);

        IntPredicate isEven = (i) -> {
            return i % 2 == 0;
        };

        long start = System.currentTimeMillis();

        ints1.limit(NUMBERS_TO_PROCESS).filter(isEven).reduce(0, (left, right) -> left + right);

        long endSeq = System.currentTimeMillis();

        ints2.parallel().limit(NUMBERS_TO_PROCESS).filter(isEven).reduce(0, (left, right) -> left + right);

        long endPar = System.currentTimeMillis();

        System.out.println("Sequential -> " + (endSeq - start));
        System.out.println("Parallel -> " + (endPar - endSeq));
    }
}
