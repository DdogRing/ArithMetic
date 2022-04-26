package com.ddogring.juc1;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁(手写)
 * @author DdogRing
 */
public class MyCAS {

    public static void main(String[] args) {

        MyLock myLock = new MyLock();
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {

                myLock.lock();
                try {
                    System.out.println(Thread.currentThread().getName()+"锁住了");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    myLock.unlock();
                }
            }).start();
        }
    }

}
class MyLock {
    AtomicReference<Thread> atomicReference = new AtomicReference(null);
    public void lock() {
        Thread thread = Thread.currentThread();
        while (!atomicReference.compareAndSet(null, thread)){
            System.out.println(Thread.currentThread().getName() + "旋着呢");
        }
    }

    public void unlock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);
    }
}
