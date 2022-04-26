package com.ddogring.juc1;

import java.util.concurrent.*;

/**
 * @author DdogRing
 * 线程池
 */
public class ExecutorDemo {
    public static void main(String[] args) throws InterruptedException {

        // 查看当前运行环境CPU核心数
        System.out.println(Runtime.getRuntime().availableProcessors());
        // ExecutorService executorService = Executors.newCachedThreadPool();
        // ExecutorService executorService = Executors.newSingleThreadExecutor();
        // ExecutorService executorService = Executors.newFixedThreadPool(5);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        try {
            for (int i = 1; i <= 2; i++) {
                executor.execute(() -> {
                    System.out.println(Thread.currentThread().getName());
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }

        //System.out.println();

        TimeUnit.SECONDS.sleep(600000);
    }
}
