package com.jy.dao;

/**
 * @program: pringaopdemo1
 * @description JDK 动态代理
 * @author: JasonYell
 * @create: 2024-08-17 00:17
 **/

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 * JDK 动态代理 : 通过被代理对象实现接口，产生其代理对象的
 *
 * 1. 创建一个类，实现InvocationHandler接口，重写Invoke方法
 * 2. 在类中定义一个Object类型的变量，并提供这个变量的有参构造器，用于将被代理对象传递进来
 * 3. 创建getProxy方法，用于创建并返回代理对象
 * 4.
 *
 */
public class MyDynamicProxy implements InvocationHandler {

    //被代理对象
    private Object obj;

    public MyDynamicProxy(Object obj) {
        this.obj = obj;
    }

    // 产生代理对象
    public Object getProxy(){
        // 1.获取被代理对象的类加载器
        ClassLoader classLoader = obj.getClass().getClassLoader();

        // 2.获取被代理对象的类实现的接口
        Class<?>[] interfaces = obj.getClass().getInterfaces();

        // 3.产生代理对象(通过被代理对象的类加载器及实现的接口)
        // 第一个参数：被代理对象的类加载器
        // 第二个参数：被代理对象实现的接口
        // 第三个参数：使用产生代理对象调用方法时，用于拦截方法执行的拦截器
        Object proxy = Proxy.newProxyInstance(classLoader, interfaces, this);

        return proxy;
    }

    // 实现InvocationHandler接口方法
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        begin();
        Object returnValue = method.invoke(obj);
        commit();

        return returnValue;
    }

    public void begin(){
        System.out.println("begin");
    }

    public void commit(){
        System.out.println("commit");
    }

}
