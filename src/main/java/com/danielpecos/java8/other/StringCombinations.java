package com.danielpecos.java8.other;

// https://dzone.com/articles/java-8-string-all-combinations-in-parallel

import java.math.BigInteger;
import java.util.Date;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringCombinations {

    private static AtomicBigInteger count = new AtomicBigInteger(new BigInteger("-1"));

    public static BigInteger combinationsCount(BigInteger num) {
        if (num.equals(BigInteger.ZERO))
            return BigInteger.ZERO;
        return num.multiply(combinationsCount(num.subtract(BigInteger.ONE))).add(num);

    }


    public static Stream<String> combinations(String str) {

        int number = str.length();
        BigInteger max = combinationsCount(new BigInteger(String.valueOf(number)));
        System.out.println("Combinations of " + number + "=" + max.toString() + " for " + str);

        Stream<String> curStream = IntStream.range(0, str.length()).boxed()
                .flatMap(i -> combinationsHelper(i, str));

        return curStream;

    }

    public static Stream<String> combinationsHelper(int len, String str) {

        if (str.length() == len) {
            BigInteger cnt = count.incrementAndGet();
            if (cnt.compareTo(BigInteger.ZERO) > 0 && cnt.remainder(new BigInteger("1000")).equals(BigInteger.ZERO)) {
                System.out.println(cnt + " are done...");
            }

            return Stream.of("");
        }

        return IntStream.range(0, str.length()).boxed().flatMap(
                i -> combinationsHelper(len, str.substring(0, i) + str.substring(i + 1)).map(t -> str.charAt(i) + t));

    }

    static final class AtomicBigInteger {
        private final AtomicReference<BigInteger> valueHolder = new AtomicReference<>();

        public AtomicBigInteger(BigInteger bigInteger) {
            valueHolder.set(bigInteger);
        }

        public BigInteger incrementAndGet() {

            for (; ; ) {
                BigInteger current = valueHolder.get();
                BigInteger next = current.add(BigInteger.ONE);
                if (valueHolder.compareAndSet(current, next)) {
                    return next;
                }
            }
        }

    }

    public static void main(String[] args) {

        int rangeLow = 65;
        int number = 4;

        Date startDate = new Date();

        long startTime = System.nanoTime();

        System.out.println("Started at " + startDate);

        combinations(IntStream.range(rangeLow, rangeLow + number).mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining())).parallel()
                .collect(Collectors.toSet()).stream().sorted().forEach(System.out::println);

        Date endDate = new Date();

        long totalTime = System.nanoTime() - startTime;

        System.out.println("Ended at " + endDate + " total time=" + totalTime + " nanosec");

    }

}
