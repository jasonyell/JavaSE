package com;

import java.io.Serializable;

/**
 * @program: ReflectionDemo
 * @description
 *  单例模式：
 *      1 多线程访问的安全问题
 *      2 加上 volatile 关键字保证变量的一致性
 *      3 防止反射调用私有构造方法
 *      4 让单例类可以序列化
 * @author: JasonYell
 * @create: 2023-03-08 00:30
 **/
public class Singleton implements Serializable {

    private volatile static Singleton singleton = null;

    public Singleton() {
        // 防止反射调用私有构造方法
        if(singleton != null){
            throw new RuntimeException("此类对象为单例模式，已被实例化");
        }
    }

    public static Singleton getInstance(){
        if(singleton == null){
            synchronized (singleton.getClass()){
                if(singleton==null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
