package com.example.ram.multithreading;

public class ThreadBasics {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Hello Worldl!");

        System.out.println(Thread.currentThread().getName());

        Thread t1 = new Thread(new Task());
        t1.start();

        Thread t2 = new Thread(new Task());
        t2.start();

        Thread t3 = new Thread(new Task());
        t3.start();

        System.out.println("i AM DON");
    }


    public static class Task implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i< 100; i++) {
                System.out.println(" I - " + i + "Thread - " + Thread.currentThread().getName());
            }
        }
    }
}
