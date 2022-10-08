package com.example.ram.multithreading;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        DependentService d1 = new DependentService(cyclicBarrier);
        DependentService d2 = new DependentService(cyclicBarrier);
        DependentService d3 = new DependentService(cyclicBarrier);

        executorService.submit(d1);
        executorService.submit(d2);
        executorService.submit(d3);

    }


    public static class DependentService implements  Runnable {

        private CyclicBarrier cyclicBarrier;

        public DependentService(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("Thread started : " + Thread.currentThread().getName());
            try {
                Thread.sleep(5000L);
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread finished job.");
        }
    }
}
