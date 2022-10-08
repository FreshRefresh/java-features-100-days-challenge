package com.example.ram.multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

public class CountDownLatchDemo {

    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(2);

        System.out.println("Running main trhead - " + Thread.currentThread().getName());

        Task task1 = new Task(countDownLatch);
        Task task2 = new Task(countDownLatch);

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);

        t1.start();
        t2.start();

        try {
            System.out.println("Waiting for Async threads to be complete....");
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Exit from main thread.");


    }

    public static class Task implements Runnable {

        private static AtomicLong id = new AtomicLong(0);
        private CountDownLatch countDownLatch;

        public Task(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {

            System.out.println("Executing Task by Thread : " + Thread.currentThread().getName() +
               ", ID " + id.getAndIncrement());
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            countDownLatch.countDown();
        }
    }
}
