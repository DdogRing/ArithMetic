package com.ddogring.juc2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author DdogRing
 * LockSupport
 */
public class LockSupportTest001 {
    public static void main(String[] args) {

        Lock lock = new ReentrantLock();

        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "进来了");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "出去了");
        },"t1");
        thread.start();

        new Thread(() -> {
            LockSupport.unpark(thread);
        },"t2").start();
    }
}
