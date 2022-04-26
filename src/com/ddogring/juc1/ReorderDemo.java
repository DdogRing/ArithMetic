package com.ddogring.juc1;

/**
 * @author DdogRing
 * 指令重排Demo
 */
public class ReorderDemo {
    public static int a = 0;
    public static boolean flag = false;

    public static void main(String[] args) {

        new Thread(() ->{
            m2();
        },"t1").start();

        new Thread(() ->{
            m1();
        },"t2").start();
    }

    public static void m1(){
        a = 1;
        flag = true;
    }

    public static void m2(){
        if (flag){
            System.out.println(a);
        }
    }
}
