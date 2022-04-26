package com.ddogring.juc2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author DdogRing
 * AQS Abstrct Queue Synchronizer
 */
public class AQSDemo01 {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        // 带入银行办理模拟AQS如何进行线程的管理和通知唤醒机制

        // 3个线程模拟3个来银行网点，受理窗口办理的顾客

        // A顾客就是第1个顾客，此时受理窗口没有任何人，A可以直接去办理
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("A Thread come in");
                // 暂停几分钟线程
                TimeUnit.MINUTES.sleep(20);
            } catch(Exception e){
              e.printStackTrace();
            } finally {
                lock.unlock();
            }
        },"A").start();

        // 第2个顾客,第2个线程B ----> 由于受理业务的窗口只有一个(只能一个线程持有锁)
        // 进入候客区
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("B Thread come in");
            } finally {
                lock.unlock();
            }
        },"B").start();

        // 第3个顾客,第3个线程C ----> 由于受理业务的窗口只有一个(只能一个线程持有锁)
        // 进入候客区
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("C Thread come in");
            } finally {
                lock.unlock();
            }
        },"C").start();
    }
}
