package com.ddogring.juc1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author DdogRing
 * 生产者消费者 原子
 */
public class Product_CusumerDemo2 {
    public static void main(String[] args) throws InterruptedException {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<String>(1));
        new Thread(() -> {
            try {
                myResource.incr();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"t1").start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(() -> {
            try {
                myResource.decr();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"t2").start();

    }
}

class MyResource<T>{
    private volatile boolean flag = true;
    private AtomicInteger atomicInteger = new AtomicInteger();
    private BlockingQueue<T> blockingQueue = null;

    public MyResource(BlockingQueue<T> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void incr() throws Exception {

        String data = null;
        boolean offer = false;
        while (flag){
            data = atomicInteger.incrementAndGet() + "";
            offer = blockingQueue.offer((T) data, 2L, TimeUnit.SECONDS);
            if (offer){
                System.out.println(Thread.currentThread().getName()+"\t"+"生产成功");
            }else {
                System.out.println(Thread.currentThread().getName()+"\t"+"生产失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName()+"所有生产停止");
    }

    public void decr() throws Exception {
        String data = null;
        T poll = null;
        while(flag){
            data = atomicInteger.decrementAndGet() + "";
            poll = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (null == poll || "".equals(poll)){
                System.out.println(Thread.currentThread().getName()+"\t"+"消费失败");
            }else {
                System.out.println(Thread.currentThread().getName()+"\t"+"消费成功");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName()+"所有消费停止");
    }
}
