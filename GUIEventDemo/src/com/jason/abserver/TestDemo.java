package com.jason.abserver;

import org.junit.Test;

/**
 * @program: GUIEventDemo
 * @description
 * @author: JasonYell
 * @create: 2023-03-19 02:09
 **/
public class TestDemo {

    @Test
    public void testObserver(){
        //
        Message message = new Message();

        Observer observer1 = new User("jason");
        Observer observer2 = new User("jason2");
        Observer observer3 = new User("jason3");

        message.registerObserver(observer1);
        message.registerObserver(observer2);
        message.registerObserver(observer3);

        message.setMessage("message send");

        message.removeObserver(observer1);
//        message.removeObserver(observer2);
//        message.removeObserver(observer3);
        System.out.println("===========================================");
        message.setMessage("hello world");

    }
}
