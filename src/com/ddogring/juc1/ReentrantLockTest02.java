package com.ddogring.juc1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author DdogRing
 * 递归锁(可重入锁)
 *
 * 指的是同一线程外层函数获得锁之后，内存递归函数仍然能获取该锁的代码
 * 在同一线程在外层获取锁的时候，在进入内层方法会自动获得锁
 *
 * 也就是说，线程可以进入任何一个它已经拥有锁所同步的代码块
 */
public class ReentrantLockTest02 {
    public static void main(String[] args) throws InterruptedException {

        Phone phone = new Phone();
        new Thread(() ->{
            phone.senMsg();
        },"t1").start();

        new Thread(() ->{
            phone.senMsg();
        },"t2").start();

        TimeUnit.SECONDS.sleep(1);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        new Thread(new Phone(),"t3").start();
        new Thread(new Phone(),"t4").start();
    }
}

class Phone implements Runnable{

    Lock lock = new ReentrantLock();

    public synchronized void senMsg(){
        System.out.println(Thread.currentThread().getId()+"\t"+"invoke senMsg");
        sendEmail();
    }

    public synchronized void sendEmail(){
        System.out.println(Thread.currentThread().getId()+"\t"+"invoke sendEmail");
    }

    @Override
    public void run() {
        get();
    }
    public void set(){

        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t"+"invoke set()");
        } finally {
            lock.unlock();
        }
    }

    public void get(){

        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t"+"invoke get()");
            set();
        } finally {
            lock.unlock();
        }
    }
}