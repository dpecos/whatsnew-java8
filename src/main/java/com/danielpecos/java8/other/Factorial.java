package com.danielpecos.java8.other;

// https://dzone.com/articles/java-8-factorial

import java.math.BigInteger;
import java.util.stream.Stream;

public class Factorial {

    static class Pair {
        final BigInteger num;
        final BigInteger value;

        Pair(BigInteger num, BigInteger value) {
            this.num = num;
            this.value = value;
        }
    }

    public static BigInteger factorial(BigInteger num) {

        Stream<Pair> allFactorials = Stream.iterate(new Pair(BigInteger.ONE, BigInteger.ONE),
                x -> new Pair(x.num.add(BigInteger.ONE), x.value.multiply(x.num.add(BigInteger.ONE))));

        return allFactorials.filter((x) -> x.num.equals(num)).findAny().get().value;

    }

    public static BigInteger factorialClassic(BigInteger x) {

        if (x.compareTo(new BigInteger("2")) < 0)
            return BigInteger.ONE;
        else
            return x.multiply(factorial(x.subtract(BigInteger.ONE)));

    }

    public static void main(String[] args) {
        System.out.println(factorial(new BigInteger("100")));

        System.out.println(factorialClassic(new BigInteger("100")));
    }

}
