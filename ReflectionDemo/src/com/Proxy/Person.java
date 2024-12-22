package com.Proxy;

/**
 * @program: ReflectionDemo
 * @description
 * @author: JasonYell
 * @create: 2023-03-03 00:59
 **/
public class Person implements Subject, Hotel {

    @Override
    public void shopping() {
        System.out.println("付款 买到心仪的衣服");
    }

    @Override
    public void reserve() {
        System.out.println("付款预定，打飞机前往目的地");
    }
}
