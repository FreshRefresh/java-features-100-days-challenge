package com.example.ram.multithreading;

import java.util.concurrent.ThreadFactory;

public class SimpleThreadFactory implements ThreadFactory {

    public static void main(String[] args) throws InterruptedException {

        SimpleThreadFactory simpleThreadFactory = new SimpleThreadFactory();
        Thread t1 = simpleThreadFactory.newThread(() -> {

            System.out.println("Thread - " + Thread.currentThread().getName());
            System.out.println("Thread - " + Thread.currentThread().getThreadGroup());
            System.out.println("Thread - " + Thread.currentThread().getId());
            System.out.println("Thread - " + Thread.currentThread().getState());
            System.out.println("Hello world!");
        });
        t1.start();
        Thread.currentThread().join();
    }

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r);
    }
}
