package com.ddogring.juc1;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Semaphore
 * @author DdogRing
 */
public class SemaphoreDemo {
    public static void main(String[] args){

        // 模拟3个停车位
        Semaphore semaphore = new Semaphore(3);

        // 模拟6部汽车
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t" + "抢到车位");
                    int i1 = (int) (Math.random() * 10);
                    TimeUnit.SECONDS.sleep(i1);
                    System.out.println(Thread.currentThread().getName() + "\t" +"停车" + i1 + "s离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }
}
