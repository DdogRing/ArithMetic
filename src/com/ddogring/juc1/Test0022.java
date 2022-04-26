package com.ddogring.juc1;

import java.util.ArrayList;

/**
 * @author DdogRing
 */
public class Test0022 {

    private static boolean flag = false;
    public static void main(String[] args) throws InterruptedException {

        /*new Thread(() -> {
            System.out.println(!flag);
            while (!flag){
                new ArrayList<>(100);
            }
            System.out.println("123");
        },"t1").start();

        TimeUnit.SECONDS.sleep(1);

        flag = true;*/

        ArrayList arrayList = new ArrayList<String>();

        /*for (int i = 0; i < 10000; i++) {
            new ArrayList<>();
            arrayList.add(1);
        }

        try {
            Class<?> aClass = Class.forName("java.lang.Shutdown");
            Object o = aClass.newInstance();
            Method halt = aClass.getDeclaredMethod("halt");
            halt.invoke(o,0);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        */

    }
}
