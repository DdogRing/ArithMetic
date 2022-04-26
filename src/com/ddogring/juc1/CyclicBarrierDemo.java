package com.ddogring.juc1;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author DdogRing
 * CyclicBarrier
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {

        Runnable barrierAction;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> System.out.println("*******"));

        for (int i = 0; i < 7; i++) {
            final int b = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + ":" + b);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
