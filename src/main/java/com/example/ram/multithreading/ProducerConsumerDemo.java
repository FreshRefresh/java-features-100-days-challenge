package com.example.ram.multithreading;

import lombok.Builder;
import lombok.Getter;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Reference
 * https://www.baeldung.com/java-producer-consumer-problem
 */
public class ProducerConsumerDemo {

    public static void main(String[] args) {
        DataQueue dataQueue = new DataQueue(100);
        Producer producer = new Producer(dataQueue);
        Thread producerThread = new Thread(producer);

        Consumer consumer = new Consumer(dataQueue);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();

        producer.stop();
        consumer.stop();
    }

    public static class Producer implements Runnable {
        private final DataQueue dataQueue;
        private volatile boolean runFlag;

        public Producer(DataQueue dataQueue) {
            this.dataQueue = dataQueue;
            this.runFlag = true;
        }

        @Override
        public void run() {
            produce();
        }

        public void stop() {
            this.runFlag = false;
            dataQueue.notifyAllForEmpty();
        }

        private void produce() {
            while (runFlag) {
                Data message = generateMessage();
                while (dataQueue.isFull()) {
                    try {
                        dataQueue.waitOnFull();
                    } catch (InterruptedException e) {
                        break;
                    }
                }
                if (!runFlag) {
                    break;
                }
                dataQueue.add(message);
                dataQueue.notifyAllForEmpty();
            }
        }

        private Data generateMessage() {
            return Data.builder().id("Sfdsf").context("sdfsd").build();
        }
    }

    public static class Consumer implements Runnable {
        private final DataQueue dataQueue;
        private volatile boolean runFlag;

        public Consumer(DataQueue dataQueue) {
            this.dataQueue = dataQueue;
            this.runFlag = true;
        }

        @Override
        public void run() {
            consume();

        }

        public void stop() {
            this.runFlag = false;
            dataQueue.notifyAllForFull();
        }

        private void consume() {
            while (runFlag) {
                Data message;
                if (dataQueue.isEmpty()) {
                    try {
                        dataQueue.waitOnEmpty();
                    } catch (InterruptedException e) {
                        break;
                    }
                }
                if (!runFlag) {
                    break;
                }
                message = dataQueue.remove();
                dataQueue.notifyAllForFull();
                useMessage(message);
            }
        }

        private void useMessage(Data message) {
            System.out.println("Processing Consumed Message - " + message);
        }
    }

    @Builder
    @Getter
    public static class Data {
        private String context;
        private String id;

    }

    public static class DataQueue {
        private Queue<Data> dataQueue = new LinkedList<>();
        public int maxSize;
        private static Object FULL_QUEUE_LOCK = new Object();
        private static Object EMPTY_QUEUE_LOCK = new Object();

        public DataQueue(int maxSize) {
            this.maxSize = maxSize;
        }

        public boolean isFull() {
            if (maxSize == dataQueue.size()) {
                return true;
            }
            return false;
        }

        public boolean isEmpty() {
            if (maxSize == 0) {
                return true;
            }
            return false;
        }

        public void waitOnFull() throws InterruptedException {
            synchronized (FULL_QUEUE_LOCK) {
                FULL_QUEUE_LOCK.wait();
            }
        }

        public void notifyAllForFull() {
            synchronized (FULL_QUEUE_LOCK) {
                FULL_QUEUE_LOCK.notifyAll();
            }
        }

        public void waitOnEmpty() throws InterruptedException {
            synchronized (EMPTY_QUEUE_LOCK) {
                EMPTY_QUEUE_LOCK.wait();
            }
        }

        public void notifyAllForEmpty() {
            synchronized (EMPTY_QUEUE_LOCK) {
                EMPTY_QUEUE_LOCK.notify();
            }
        }

        public void add(Data message) {
            synchronized (dataQueue) {
                dataQueue.add(message);
            }
        }

        public Data remove() {
            synchronized (dataQueue) {
                return dataQueue.poll();
            }
        }
    }
}
