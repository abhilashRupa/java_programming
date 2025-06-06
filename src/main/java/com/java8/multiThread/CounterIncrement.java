package com.java8.multiThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class CounterIncrement {

    private static AtomicInteger atomicCounter = new AtomicInteger(0);

    private static final int NUMBER_OF_THREADS = 10;
    private static final int NUMBER_OF_INCREMENT = 100;

    public static void main(String[] args) {

        incrementByForLoop();
        incrementByIntStream();

    }

    private static void incrementByIntStream() {

        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        IntStream.range(0, NUMBER_OF_INCREMENT).forEach(i -> {
            executorService.submit(() -> {
                int currentValue = atomicCounter.incrementAndGet();

                System.out.println("current thread: " + Thread.currentThread().getName() + " current counter value: " + currentValue);

            });
        });

        executorService.shutdown();
        while (!executorService.isTerminated()) {
        }
        System.out.println(atomicCounter);
    }

    private static void incrementByForLoop() {

        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        for (int i = 0; i < NUMBER_OF_INCREMENT; i++) {
            executorService.execute(() -> {
                int currentValue = atomicCounter.incrementAndGet();
                System.out.println("thread: " + Thread.currentThread().getName() + " current counter: " + currentValue);
            });
        }
        executorService.shutdown();
    }

}
