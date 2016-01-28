package com.danielpecos.java8.options;

import java.util.Optional;
import java.util.Random;

public class Optional_01_basic {

    public static void main(String args[]) {
        for (int i = 0; i < 10; i++) {
            String value = Optional.ofNullable(maybe()).orElse("Medium");
            System.out.println("Try " + i + " -> " + value);
        }
    }

    private static String maybe() {
        int value = new Random().nextInt(10);
        if (value < 3) return "Low";
        else if (value > 7) return "High";
        else return null;
    }

}
