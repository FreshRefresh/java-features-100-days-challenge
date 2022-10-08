package com.example.ram.multithreading;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Avoid Synchronoization
 * Do not shared variables
 * Do not perform io
 */
public class ForkJoinDemo {

    public static void main(String[] args) {

        Fibonacci fibonacci = new Fibonacci(20);
        ForkJoinPool forkJoinPool = new ForkJoinPool(10);
        forkJoinPool.submit(fibonacci);
        System.out.println("Result - " + fibonacci.join());

    }

    public static class Fibonacci extends RecursiveTask<Integer> {

        private final int n;

        public Fibonacci(int n) {
            this.n = n;
        }

        @Override
        protected Integer compute() {
            if (n <= 1) {
                return n;
            }
            Fibonacci f1 = new Fibonacci(n - 1);
            f1.fork();
            Fibonacci f2 = new Fibonacci(n - 2);
            f2.fork();
            return f2.join() + f1.join();
        }
    }
}
