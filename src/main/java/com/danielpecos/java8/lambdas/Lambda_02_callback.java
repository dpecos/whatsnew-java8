package com.danielpecos.java8.lambdas;

import java.util.ArrayList;
import java.util.List;

interface DataProcessor {
    void processData(List<String> data);
}

public class Lambda_02_callback {

    public static void longOperation(DataProcessor processor) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.println("Error while sleeping");
        }

        List<String> results = new ArrayList<>();
        results.add("Result 1");
        results.add("Result 2");
        results.add("Result 3");

        processor.processData(results);
    }

    public static void main(String[] args) {
        longOperation(new DataProcessor() {
            @Override
            public void processData(List<String> data) {
                for (String result : data) {
                    System.out.println(result);
                }
            }
        });

        System.out.println("Now with Java 8");

        longOperation((data) -> {
            for (String result : data) {
                System.out.println(result);
            }
        });
    }

}
