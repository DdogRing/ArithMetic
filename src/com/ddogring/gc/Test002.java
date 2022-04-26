package com.ddogring.gc;

/**
 * @author DdogRing
 *
 * System
 *  Map<String, String> tempProps = SystemProps.initProperties();
 *         VersionProps.init(tempProps);
 *
 */
public class Test002 {
    public static void main(String[] args) {
        String s = new StringBuilder("us").append("er").toString();

        // intern()有两个作用，第一个是将字符串字面量放入常量池（如果池没有的话），第二个是返回这个常量的引用
        System.out.println(s == s.intern());

        String s1 = new StringBuilder("ap").append("er").toString();
        System.out.println(s1 == s1.intern());
    }
}
