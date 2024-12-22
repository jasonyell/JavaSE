package com.jy.test;

import com.jy.dao.BookDAOImpl;
import com.jy.dao.CGLIBDynamicProxy;

/**
 * @program: pringaopdemo1
 * @description
 * @author: JasonYell
 * @create: 2024-08-17 01:09
 **/
public class TestCGLibProxyTest {
    public static void main(String[] args) {
        // 创建被代理对象
        BookDAOImpl bookDAO = new BookDAOImpl();
        // 通过cglib动态代理类创建代理对象
        CGLIBDynamicProxy cglibDynamicProxy = new CGLIBDynamicProxy(bookDAO);
        // 代理对象实际上是被代理对象的子类，因此代理对象可直接强转为代理类类型
        BookDAOImpl proxy = (BookDAOImpl) cglibDynamicProxy.getProxy();
        // 适用对象调用方法，实际上并没有执行这个方法，而是执行了代理类中intercept方法，将当前调用的方法以及方法中的参数传递到interc方法
        proxy.insert();

    }
}
