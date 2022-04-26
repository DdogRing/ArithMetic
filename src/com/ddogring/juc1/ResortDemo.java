package com.ddogring.juc1;

/**
 * @author DdogRing
 * 重排的案例
 */
public class ResortDemo {

    int a = 0;
    boolean flag = false;

    public void method1(){
        a = 1;
        flag = true;
    }

    public void method2(){

        if (flag = true){
            a = a + 5;
            System.out.println(a);
        }
    }

    public static void main(String[] args) {

    }
}
