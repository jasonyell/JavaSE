package com.jason.abserver;


/**
 * @program: GUIEventDemo
 * @description
 *  ���۲��ߵĽӿ�
 * @author: JasonYell
 * @create: 2023-03-19 01:56
 **/
public interface MessageSubject {
    // ע��۲���
    void registerObserver(Observer o);
    // �Ƴ��۲���
    void removeObserver(Observer o);
    // ֪ͨ���й۲���
    void notifyObservers();
}
