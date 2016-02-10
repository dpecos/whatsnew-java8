package com.danielpecos.java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Stream_01_basic {

    public static void classicDemo1(List<String> list) {
        System.out.println("--- Classic - Demo 1 ---");

        for (String item : list) {
            System.out.println(item.toUpperCase());
        }
    }

    public static void demo1(List<String> list) {
        System.out.println("--- Demo 1 ---");

        list
                .stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }


    public static void classicDemo2(List<String> list) {
        System.out.println("--- Classic - Demo 2 ---");

        List<String> filteredList = new ArrayList<>();

        for (String item : list) {
            if (item.startsWith("c")) {
                filteredList.add(item.toUpperCase());
            }
        }

        filteredList.sort(String::compareTo);

        for (String item : filteredList) {
            System.out.println(item);
        }
    }

    public static void demo2(List<String> list) {
        System.out.println("--- Demo 2 ---");

        list
                .stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<String> myList =
                Arrays.asList("a1", "a2", "b1", "c2", "c1");

        classicDemo1(myList);
        demo1(myList);

        classicDemo2(myList);
        demo2(myList);

    }
}
