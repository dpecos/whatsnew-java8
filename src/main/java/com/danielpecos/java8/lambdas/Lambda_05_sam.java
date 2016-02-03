package com.danielpecos.java8.lambdas;

public class Lambda_05_sam {

    @FunctionalInterface
    interface FI1 {
        boolean isFunctional();
        //void execute();
    }

    @FunctionalInterface
    interface FI2 {
        boolean isFunctional();

        default void execute() {
            System.out.println("working...");
        }
    }

    public static void main(String[] args) {
        FI1 lambda1 = () -> true;
        FI2 lambda2 = () -> true;
        lambda2.execute();
    }

}
