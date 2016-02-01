package com.danielpecos.java8.lambdas;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public class Lambda_04_method_references {

    public static void main(String[] args) {

        Person p = new Person("John Doe", 32);

        Supplier<String> nameGetter = p::getName;
        Supplier<Integer> ageGetter = p::getAge;

        System.out.println("Name: " + nameGetter.get());
        System.out.println("Age: " + ageGetter.get());

        BiFunction<String, Integer, Person> factory = Person::new;
        Person newPerson = factory.apply("Phil Smith", 23);

        System.out.println("Name of new person: " + newPerson.getName());
    }
}
