package com.ddogring.juc1;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author DdogRing
 * 读写锁
 *
 * 多个线程同时读取一个资源没有任何问题，所以为了满足并发量，读取共享资源可以同时进行
 * 但是
 * 同时有一个线程想去写共享资源，就不应该再有其他线程可以对资源进行读或写
 * 小总结：
 *  读-读 可共存
 *  读-写 不可共存
 *  写-写 不可共存
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();

        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(() ->{
                myCache.put(temp+"",temp+"");
            },String.valueOf(i)).start();
        }

        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(() ->{
                myCache.get(temp+"");
            },String.valueOf(i)).start();
        }
    }
}

class MyCache {
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private volatile Map<String,Object> map = new HashMap<>();
    // Lock lock = new ReentrantLock();
    ReadWriteLock lock = new ReentrantReadWriteLock();
    public void put(String key,Object value){
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"正在写入" + key);
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"写入完成");
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void get(String key){
        lock.writeLock().lock();
        try {
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"正在读取");
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName()+"读取完成:" + o);
        } finally {
            lock.writeLock().unlock();
        }
    }
}
