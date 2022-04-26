package com.ddogring.juc1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author DdogRing
 * Synchronized and ReentrantLock
 * 精准通知/唤醒
 */
public class SynchronizeAndReentrantLockDemo {
    public static void main(String[] args) {

        ShareResource shareResource = new ShareResource();

        for (int i = 0; i < 8; i++) {
            new Thread(() -> {
                shareResource.print5();
            },"t1").start();
        }

        for (int i = 0; i < 8; i++) {
            new Thread(() -> {
                shareResource.print10();
            },"t2").start();
        }

        for (int i = 0; i < 8; i++) {
            new Thread(() -> {
                shareResource.print15();
            },"t3").start();
        }
    }
}

class ShareResource{
    // 线程计数
    private int num = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void print5(){

        lock.lock();
        try {
            while(num != 1){
                condition1.await();
            }
            num = 2;
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName()+"----->" + i);
            }
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void print10(){

        lock.lock();
        try {
            while(num != 2){
                condition2.await();
            }
            num = 3;
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName()+"----->" + i);
            }
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print15(){

        lock.lock();
        try {
            while(num != 3){
                condition3.await();
            }
            num = 1;
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName()+"----->" + i);
            }
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
