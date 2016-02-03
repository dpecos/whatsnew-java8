package com.danielpecos.java8.lambdas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lambda_02_sort {

    public static void main(String[] args) {
        List<String> lines = new ArrayList<>();

        lines.add("Lorem ipsum dolor sit amet, consectetur adipiscing ");
        lines.add("elit, sed do eiusmod tempor incididunt ut labore et ");
        lines.add("dolore magna aliqua. Ut enim ad minim veniam, quis nostrud");
        lines.add("exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
        lines.add("Duis aute irure dolor in reprehenderit in voluptate velit");
        lines.add("esse cillum dolore eu fugiat nulla pariatur. Excepteur sint ");
        lines.add("occaecat cupidatat non proident, sunt in culpa qui officia deserunt");
        lines.add("mollit anim id est laborum.");

        lines.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        lines.forEach(System.out::println);

        System.out.println("----");

        lines.sort((o1, o2) -> o1.compareToIgnoreCase(o2));

        lines.forEach(System.out::println);
    }

}
