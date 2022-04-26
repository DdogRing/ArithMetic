package com.ddogring.juc1;

import java.util.concurrent.CountDownLatch;

/**
 * @author DdogRing
 * CountDownLatch
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 0; i < 6; i++) {
            new Thread(() ->{
                System.out.println(Thread.currentThread().getName());
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName());
    }
}
