package com.jy.dao;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @program: pringaopdemo1
 * @description
 *
 *  1. 添加CGLIB依赖
 *  2. 创建一个类，实现MethodInterceptor接口，同时实现接口中的intercept方法
 *  3. 在类中定义一个Object类型的变量，并提供这个变量的有参构造器，用于场地被代理对象
 *  4. 定义getProxy方法创建并返回代理对象（代理对象是通过创建被代理类的子类来创建）
 *
 * @author: JasonYell
 * @create: 2024-08-17 00:50
 **/
public class CGLIBDynamicProxy implements MethodInterceptor {

    private Object obj;

    public CGLIBDynamicProxy(Object obj) {
        this.obj = obj;
    }

    public Object getProxy(){
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(obj.getClass());
        enhancer.setCallback(this);

        Object proxy = enhancer.create();
        return proxy;
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        insert();
        Object invoke = method.invoke(obj,objects);  // 通过反射调用被代理类的方法
        commit();

        return invoke;
    }

    private void insert(){
        System.out.println("begin");
    }

    private void commit(){
        System.out.println("commit");
    }

}
