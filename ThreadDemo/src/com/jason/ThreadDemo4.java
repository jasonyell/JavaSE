package com.jason;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: ThreadDemo
 * @description
 *  1 多线程共享数据时，会发生线程不安全的情况（）
 *  2 多线程共享数据必须使用同步
 *  3 实现同步的三种方法：
 *      使用同步代码块
 *      使用同步方法
 *      使用Lock
 *  多线程共性数据，会有安全问题，使用同步代码块解决安全问题，但同时会牺牲性能，所以同步的代码块要尽量简洁
 *  把不随数据变化的相关代码移除同步块，不要阻塞
 *
 * @author: JasonYell
 * @create: 2023-02-24 00:47
 **/
public class ThreadDemo4 {

    public static void main(String[] args) {
        MyRunnable5 mr5 = new MyRunnable5();
        Thread t5 = new Thread(mr5);
        Thread t2 = new Thread(mr5);
        t2.start();
        t5.start();
    }

}

class MyRunnable5 implements Runnable{
    Object obj = new Object();   // 同步锁
    private int ticket = 10; // 售票

    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
//            if(ticket>0){
//                synchronized (this){
//                    ticket--;
//                    try {
//                        Thread.sleep(300);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("您购买的票已经剩余"+ticket+"张");
//                }
        method1();
        }
    }
    // 同步方法:同步的对象是当前对象（this）
    private synchronized void method1(){
        if(ticket>0){
            ticket--;
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("您购买的票已经剩余"+ticket+"张");
        }
    }

    // 互斥锁
    ReentrantLock lock = new ReentrantLock();
    //Lock 实现同步
    private void method2(){
        lock.lock(); // 锁
        try{
            if(ticket>0){
                ticket--;
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("您购买的票已经剩余"+ticket+"张");
            }
        }finally {
            lock.unlock(); // 释放锁
        }
    }
}
