package com.ddogring.juc1;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author DdogRing
 * 容器(集合)不安全问题  ArrayList
 */
public class ContainerNotSafeDemo {

    public static void main(String[] args) {

        // List<String> list = new Vector<>();  // new ArrayList
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < 3000; i++) {
            new Thread(() ->{
                list.add("1");
                System.out.println(list);
            },String.valueOf(i)).start();
        }
        /*java.util.ConcurrentModificationException*/
    }
}
