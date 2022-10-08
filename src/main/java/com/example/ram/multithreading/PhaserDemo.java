package com.example.ram.multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class PhaserDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Phaser phaser = new Phaser(3);
        DependentService d1 = new DependentService(phaser);
        DependentService d2 = new DependentService(phaser);
        DependentService d3 = new DependentService(phaser);

        executorService.submit(d1);
        executorService.submit(d2);
        executorService.submit(d3);


        phaser.awaitAdvance(1);
        System.out.println("Exit from main thread.");

    }


    public static class DependentService implements Runnable {

        private Phaser phaser;

        public DependentService(Phaser phaser) {
            this.phaser = phaser;
        }

        @Override
        public void run() {
            System.out.println("Thread started : " + Thread.currentThread().getName());
            try {
                Thread.sleep(5000L);
                phaser.arriveAndAwaitAdvance();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread finished job.");
        }
    }
}
