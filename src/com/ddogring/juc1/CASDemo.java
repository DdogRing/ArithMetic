package com.ddogring.juc1;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author DdogRing
 * CAS 例子
 */
public class CASDemo {
    public static void main(String[] args) {
        // 初始化6
        AtomicInteger atomicInteger = new AtomicInteger(6);

        // 期望值6 ，修改为8
        System.out.println(atomicInteger.compareAndSet(6, 8)+":"+atomicInteger.get());
        // 期望值6 ，修改为10
        System.out.println(atomicInteger.compareAndSet(6,10)+":"+atomicInteger.get());

    }

    // Lock lock = new ReentrantLock(true);
    public synchronized void test1(){

    }

}
