package com.danielpecos.java8.options;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Optional_03_signature {

    public static String repeat(String what, int howManyTimes, String prefix) {

        return prefix != null ? prefix : "" +
                IntStream.range(0, howManyTimes)
                        .mapToObj((i) -> what)
                        .collect(Collectors.joining());

    }

    public static String repeatBetter(String what, int howManyTimes, Optional<String> prefix) {

        return prefix.orElse("") +
                IntStream.range(0, howManyTimes)
                        .mapToObj((i) -> what)
                        .collect(Collectors.joining());

    }

    public static void main(String[] args) {

        System.out.println(repeat("ho", 3, "hi"));
        System.out.println(repeat("ho", 3, ""));
        System.out.println(repeat("ho", 3, null));

        System.out.println("---");

        System.out.println(repeatBetter("ho", 3, Optional.of("hi")));
        System.out.println(repeatBetter("ho", 3, Optional.empty()));
    }

}
