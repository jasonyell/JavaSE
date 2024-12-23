package com.jason.abserver;


/**
 * @program: GUIEventDemo
 * @description
 *  被观察者的接口
 * @author: JasonYell
 * @create: 2023-03-19 01:56
 **/
public interface MessageSubject {
    // 注册观察者
    void registerObserver(Observer o);
    // 移除观察者
    void removeObserver(Observer o);
    // 通知所有观察者
    void notifyObservers();
}
