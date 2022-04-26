package com.ddogring.juc1;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author DdogRing
 * Volatile
 */
public class VolatileTest01 {
    public volatile int num = 0;
    private AtomicInteger num1 = new AtomicInteger();
    LongAdder longAdder = new LongAdder();
    public static void main(String[] args) {
        VolatileTest01 volatileTest01 = new VolatileTest01();
        volatileTest01.test001();
    }
    public void test001(){
        for (int i = 0; i < 100000; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    // num++;
                    // num1.getAndIncrement();
                    longAdder.increment();
                }

            }).start();
        }
        // 线程活动数量
        if (Thread.activeCount()>2){
            // 当前线程让步
            Thread.yield();
        }
        System.out.println(num);
        System.out.println(num1.get());
        System.out.println(longAdder.intValue());
    }
}
