package com.danielpecos.java8.lambdas;

import java.util.function.*;

public class Lambda_05_finterfaces {

    public static void main(String[] args) {

        Supplier<String> producer = () -> "Cool!";
        Consumer<String> consumer = (s) -> System.out.println(s);

        BooleanSupplier optimist = () -> true;
        IntSupplier intProducer = () -> 1;
        LongSupplier longProducer = () -> 2L;
        DoubleSupplier doubleProducer = () -> 3d;

        Predicate<String> predicate = (s) -> s.isEmpty();
        BiPredicate<String, Integer> weirdPredcate = (s, n) -> s.isEmpty() && n != 3;

        Function<Integer, String> toStr = (n) -> n.toString();
        Function<String, String> toUpp = (s) -> s.toUpperCase();

        // --- composition ---

        BiFunction<Integer, String, String> toStrAppend = (n, s) -> toStr.apply(n) + s;

        Function<Integer, String> toUppStr = toStr.andThen(toUpp);
        toUppStr.apply(10);

        BiFunction<Integer, String, String> toUppAppend = toStrAppend.andThen(toUpp);
        System.out.println(toUppAppend.apply(10, " is working!"));


        // --- trigonometry --- https://en.wikipedia.org/wiki/Trigonometric_functions
        Function<Double, Double> inverse = (n) -> 1 / n;
        Function<Double, Double> sin = Math::sin;
        Function<Double, Double> cosecant = sin.andThen(inverse);
        Function<Double, Double> sinBack = cosecant.andThen(inverse);

        System.out.println(Math.sin(Math.PI) == sinBack.apply(Math.PI));
    }

}
