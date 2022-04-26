package com.ddogring.juc1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author DdogRing
 * 原子引用
 * ABA Demo
 */
public class AtomicReferenceTest01 {

    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100,1);

    public static void main(String[] args) {

        new Thread(() -> {
            atomicReference.compareAndSet(100,101);
            atomicReference.compareAndSet(101,100);
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicReference.compareAndSet(100, 102)+":"+atomicReference.get());
        }).start();


        System.out.println("解决ABA问题");
        new Thread(() ->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println("第一次Version:"+stamp);
            boolean b = atomicStampedReference.compareAndSet(100, 101, stamp, stamp + 1);
            System.out.println("第二次Version:"+atomicStampedReference.getStamp()+ (b == true ? "修改成功" : "修改失败"));
            boolean b1 = atomicStampedReference.compareAndSet(101, 100, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println("第三次Version:"+atomicStampedReference.getStamp()+ (b1 == true ? "修改成功" : "修改失败"));
        }).start();

        new Thread(() ->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println("第一次Version:"+stamp);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean b = atomicStampedReference.compareAndSet(100, 1000, stamp, stamp + 1);
            System.out.println("当前Version:" + atomicStampedReference.getStamp() + "是否修改成功:" + (b == true ? "修改成功" : "修改失败"));
        }).start();
    }
}
