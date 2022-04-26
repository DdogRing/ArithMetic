package com.ddogring.juc1;

import java.util.concurrent.TimeUnit;

/**
 * volatile关键字 可见性
 * @author DdogRing
 */
public class VolatileTest02 {

    public static boolean flag = false;
    public static void main(String[] args) throws InterruptedException {

        new Thread(() ->{
            System.out.println("循环开始");
            while(!flag){

            }
            System.out.println("循环结束");
        },"t1").start();

        TimeUnit.SECONDS.sleep(1);
        flag = true;
    }


}
