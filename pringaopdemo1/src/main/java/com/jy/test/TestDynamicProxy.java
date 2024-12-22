package com.jy.test;

import com.jy.dao.BookDAOImpl;
import com.jy.dao.GenaralDAO;
import com.jy.dao.MyDynamicProxy;

/**
 * @program: pringaopdemo1
 * @description
 * @author: JasonYell
 * @create: 2024-08-17 00:24
 **/
public class TestDynamicProxy {

    public static void main(String[] args) {

        // 被代理对象
        BookDAOImpl bookDAO = new BookDAOImpl();

        // 创建动态代理类对象，并将被代理对象传递到代理类中赋值给obj
        MyDynamicProxy myDynamicProxy = new MyDynamicProxy(bookDAO);


        // proxy 就是产生的代理对象：可以强转成被代理对象实现的接口类型
        GenaralDAO proxy = (GenaralDAO) myDynamicProxy.getProxy();

        // 使用代理对象调用方法，不会直接进入到被代理类，并不会执行调用的方法，而是进入到创建对象时指定的InvocationHandler类中的invoke方法
        // 调用的方法作为一个Method参数，传给了invoke
        proxy.delete();

    }
}
