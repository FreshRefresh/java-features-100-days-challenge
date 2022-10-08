package com.example.ram.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadDemoApp {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Thread t1 = new Thread(new TaskDemo());
        t1.start();

        CallableTaskDemo callableTaskDemo = new CallableTaskDemo();
        FutureTask<String> futureTask = new FutureTask<>(callableTaskDemo);

        Thread t2 = new Thread(futureTask);
        t2.start();

        System.out.println("Results from Future-" + futureTask.get());
    }


    public static class TaskDemo implements Runnable {

        @Override
        public void run() {
            System.out.println("TaskDemo - Running thread... " + Thread.currentThread().getName());
        }
    }

    public static class CallableTaskDemo implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println("CallableTaskDemo - Running thread... " + Thread.currentThread().getName());

            Thread.sleep(5000L);
            return "Hello World";
        }
    }
}
