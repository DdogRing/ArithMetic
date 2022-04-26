package com.ddogring.juc1;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author DdogRing
 */
public class Test0021 {

    public static void main(String[] args) {

        /*ArrayList arrayList = new ArrayList<>();*/

       /* Vector vector = new Vector();*/

        // List<Object> objects = Collections.synchronizedList(new ArrayList<>());

        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 300; i++) {
            new Thread(() -> {
                copyOnWriteArrayList.add("1");
                System.out.println(copyOnWriteArrayList);
            }).start();
        }
    }
}
