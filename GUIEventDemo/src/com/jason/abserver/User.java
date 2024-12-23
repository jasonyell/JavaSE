package com.jason.abserver;

/**
 * @program: GUIEventDemo
 * @description
 *  观察者对象
 * @author: JasonYell
 * @create: 2023-03-19 02:06
 **/
public class User implements Observer {

    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("[" +name+ "] + 接收到的消息：_"+message);
    }
}
