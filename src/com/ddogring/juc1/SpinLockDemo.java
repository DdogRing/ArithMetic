package com.ddogring.juc1;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author DdogRing
 * 实现自旋锁
 *
 * 自旋锁好处： 循环比较到成功为止，不会阻塞，每次都是轮询
 *
 * 缺点：十分消耗CPU资源
 *
 * 通过CAS操作完成自旋锁，A线程先进来调用myLock方法自己持有5秒，B随后进来发现
 * 当前线程持有锁，不是null，所以只能、自旋等待，直到A释放锁
 */
public class SpinLockDemo {

    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void lock(){
        Thread thread = Thread.currentThread();
        while (!atomicReference.compareAndSet(null,thread)){
            System.out.println(Thread.currentThread().getName()+"旋着呢");
        }
        System.out.println(Thread.currentThread().getName()+"锁住了");
    }

    public void unLock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);
    }

    public static void main(String[] args) {

        SpinLockDemo spinLockDemo = new SpinLockDemo();

        for (int i = 0; i < 12; i++) {

            new Thread(() ->{
                spinLockDemo.lock();
                try {
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    spinLockDemo.unLock();
                }
            },String.valueOf(i)).start();
        }
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*new Thread(() ->{
            spinLockDemo.lock();
            try {
                System.out.println(Thread.currentThread().getName()+"锁住了");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                spinLockDemo.unLock();
            }
        },"t2").start();*/

    }
}
