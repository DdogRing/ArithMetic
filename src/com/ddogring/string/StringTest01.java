package com.ddogring.string;

/**
 * @author DdogRing
 */
public class StringTest01 {

    public static void main(String[] args) {

        String s1 = new String("a") + new String("b");
        String s2 = "ab";

        String s3 = s1.intern();

        System.out.println(s1 == s2);
        System.out.println(s2 == s3);
    }
}
