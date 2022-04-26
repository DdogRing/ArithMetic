package com.ddogring.gc;

import java.util.concurrent.TimeUnit;

/**
 * @author DdogRing
 * OOM : Unable To Create New Native Thread
 */
public class UnableToCreateNewNativeThread {

    public static void main(String[] args) {

        for (int i = 0;; i++) {
             new Thread(()->{
                 try {
                     TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }).start();
        }
    }
}
