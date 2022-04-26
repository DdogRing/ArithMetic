package com.ddogring.juc1;

/**
 * @author DdogRing
 * 单例模式 懒汉模式
 */
public class SingleTest001 {

    // DCL 单例模式 volatile禁止指令重排
    private static volatile SingleTest001 singleTest001 = null;

    private SingleTest001() {
        System.out.println(Thread.currentThread().getName()+ "------>我是单例模式");
    }

    public static SingleTest001 getInstance(){
        if (singleTest001 == null){
            synchronized(SingleTest001.class){
                if (singleTest001 == null){
                    singleTest001 = new SingleTest001();
                }
            }
        }
        return singleTest001;
    }
}

class Test{
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Thread(() ->{
               SingleTest001.getInstance();
            }).start();
        }
    }
}
