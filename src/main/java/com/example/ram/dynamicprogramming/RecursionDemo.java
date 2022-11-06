package com.example.ram.dynamicprogramming;

public class RecursionDemo {

    public static void main(String[] args) {
        int result = sum(10);
        System.out.println("Sum of first 10 numbers = " + result);
    }

    private static int sum(int i) {

        if (i > 0) {
            return i + sum(i - 1);
        } else {
            return 0;
        }
    }
}
