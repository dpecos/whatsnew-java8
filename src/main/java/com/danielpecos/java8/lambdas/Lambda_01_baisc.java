package com.danielpecos.java8.lambdas;

public class Lambda_01_baisc {

    public static void launchJob() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hi from thread!");
            }
        };

        r.run();
    }

    public static void launchJobJava8() {
        Runnable r = () -> System.out.println("Hi from thread! Cool! isn't?");

        r.run();
    }

    public static void main(String[] args) {
        launchJob();
        launchJobJava8();
    }

}
