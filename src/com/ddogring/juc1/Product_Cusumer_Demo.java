package com.ddogring.juc1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author DdogRing
 * 生产者消费者
 */
public class Product_Cusumer_Demo {
    public static void main(String[] args) {

        ShareData shareData = new ShareData();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                shareData.increment();
            },"t1").start();

        }

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                shareData.decrement();
            },"t2").start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                shareData.decrement();
            },"t3").start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                shareData.increment();
            },"t4").start();
        }
    }
}

class ShareData {
    private int num = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment(){
        lock.lock();
        try {
            while(num != 0){
                condition.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName()+"\t"+num);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void decrement(){
        lock.lock();
        try {
            while(num == 0){
                condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName()+"\t"+num);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
