package com.danielpecos.java8.common;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {

        return name;
    }

    public List<String> getPhonebook() {
        return new ArrayList<>();
    }
}