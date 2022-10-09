package com.example.ram.multithreading;


import javax.annotation.concurrent.ThreadSafe;

public class ThreadBasicsDemo {

    public static void main(String[] args) throws InterruptedException {

        SharedInvoker sharedInvoker = new SharedInvoker();

        Thread t1 = new Thread(new SimpleTask(sharedInvoker));
        Thread t2 = new Thread(new SimpleTask(sharedInvoker));
        Thread t3 = new Thread(new NotifierTask(sharedInvoker));

        t1.start();
        t2.start();
        Thread.sleep(2000l);
        t3.start();

    }

    @ThreadSafe
    public static class SharedInvoker {

        private static Object LOCK_OBJ = new Object();

        public void doSomething() {
            synchronized (LOCK_OBJ) {
                printThreadDetails();
                try {
                    System.out.println("I am in wait state.");
                    LOCK_OBJ.wait();
                } catch (InterruptedException e) {
                    System.out.println(" Interrupted state");
                    throw new RuntimeException(e);
                }
            }
        }

        public void notifyInvokers() {
            printThreadDetails();
            synchronized (LOCK_OBJ) {
                LOCK_OBJ.notifyAll();
            }
        }

        private static void printThreadDetails() {
            System.out.println("===================================");
            System.out.println("getName " + Thread.currentThread().getName());
            System.out.println("getId " + Thread.currentThread().getId());
            System.out.println("getState " + Thread.currentThread().getState().name());
            System.out.println("getPriority " + Thread.currentThread().getPriority());
            System.out.println("getThreadGroup " + Thread.currentThread().getThreadGroup().getName());
            System.out.println("activeGroupCount " + Thread.currentThread().getThreadGroup().activeGroupCount());
            System.out.println("activeCount " + Thread.currentThread().getThreadGroup().activeCount());
            System.out.println("===================================");
        }
    }

    public static class SimpleTask implements Runnable {

        private SharedInvoker sharedInvoker;

        public SimpleTask(SharedInvoker sharedInvoker) {
            this.sharedInvoker = sharedInvoker;
        }

        @Override
        public void run() {
            sharedInvoker.doSomething();
        }
    }

    public static class NotifierTask implements Runnable {

        private SharedInvoker sharedInvoker;

        public NotifierTask(SharedInvoker sharedInvoker) {
            this.sharedInvoker = sharedInvoker;
        }

        @Override
        public void run() {
            System.out.println("Inside Notifier Task");
            sharedInvoker.notifyInvokers();
        }
    }
}
