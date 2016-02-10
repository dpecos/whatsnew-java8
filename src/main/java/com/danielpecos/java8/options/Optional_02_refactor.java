package com.danielpecos.java8.options;

import com.danielpecos.java8.common.Person;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Optional_02_refactor {

    public static void main(String[] args) {

        List<Person> persons = Arrays.asList(
                new Person("John", 35),
                new Person("Anna", 27),
                new Person("Julie", 45)
        );

        Map<String, Person> addressBook = persons.stream().collect(Collectors.toMap(Person::getName, Function.identity()));

        // pre Java 8
        List<String> phones = addressBook.get("John") != null ? addressBook.get("John").getPhonebook() : new ArrayList<>();

        // java 8
        phones = Optional.ofNullable(addressBook.get("Matt")).orElse(new Person("John Doe", 99)).getPhonebook();
    }

}
