package com.ddogring.juc1;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author DdogRing
 */
public class CASTest001 {

    public static volatile int num = 0;
    AtomicInteger atomicInteger = new AtomicInteger();
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                num++;
            }).start();
        }

        if (Thread.activeCount()>2){
            Thread.yield();
        }

        System.out.println(num);
    }

    public void m1(long i){

    }
}
