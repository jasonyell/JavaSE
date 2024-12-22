package com.jason;

import sun.awt.windows.ThemeReader;

/**
 * @program: ThreadDemo
 * @description
 *  线程可以分成 守护线程和用户线程，当进程中没有用户线程时，JVM会退出
 * @author: JasonYell
 * @create: 2023-02-23 01:40
 **/
public class ThreadDemo3 {
    public static void main(String[] args) {
        MyRunnable4 mr4 = new MyRunnable4();
        Thread t4 = new Thread(mr4);
        Thread.currentThread().setName("用户线程--");
        t4.setName("守护线程");

        //优先级高可以提高该线程抢点CPU时间片的概率大
//        t4.setPriority(Thread.MAX_PRIORITY);

        // 线程可以分成 守护线程和用户线程，当进程中没有用户线程时，JVM会退出
        t4.setDaemon(true); // 把线程设置成守护线程
//        System.out.println(t4.isAlive());
        t4.start();
//        System.out.println(t4.isAlive());

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"--"+i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i == 6){
                Thread.yield();  // 让出本次CPU执行时间片
            }
        }
    }
}

class MyRunnable4 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 40; i++) {
            System.out.println(Thread.currentThread().getName()+"--"+i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}