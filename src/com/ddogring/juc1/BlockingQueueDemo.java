package com.ddogring.juc1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author DdogRing
 * 阻塞队列
 */
public class BlockingQueueDemo {
    public static void main(String[] args) throws Exception{

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(3);

        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("b", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("c", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("d", 2L, TimeUnit.SECONDS));


    }
}

class BlockingQueueDemo2 {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                blockingQueue.put("1");
                System.out.println(Thread.currentThread().getName() + "\t" + "存入1");
                blockingQueue.put("2");
                System.out.println(Thread.currentThread().getName() + "\t" + "存入2");
                blockingQueue.put("3");
                System.out.println(Thread.currentThread().getName() + "\t" + "存入3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1").start();

        new Thread(() -> {
            try {
                blockingQueue.take();
                System.out.println(Thread.currentThread().getName() + "\t" + "取出1");
                TimeUnit.SECONDS.sleep(5);
                blockingQueue.take();
                System.out.println(Thread.currentThread().getName() + "\t" + "取出2");
                TimeUnit.SECONDS.sleep(5);
                blockingQueue.take();
                System.out.println(Thread.currentThread().getName() + "\t" + "取出3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2").start();
    }
}