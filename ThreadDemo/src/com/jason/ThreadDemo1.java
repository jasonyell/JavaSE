package com.jason;

/**
 * @program: ThreadDemo
 * @description
 *  线程的休眠
 *  在当前线程的执行中，暂停指定的毫秒数，释放CPU的时间片
 * @author: JasonYell
 * @create: 2023-02-23 00:26
 **/
public class ThreadDemo1 {
    public static void main(String[] args) {
        MyThread mt = new MyThread();

        /**
         * 推荐
         */
        MyRunnable mr = new MyRunnable();
        Thread t2 = new Thread(mr);


        mt.start();   // 启动线程
        t2.start();
    }
}

/**
 * 实现线程的第一种方法： 继承 Thread 类
 */
class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(i);
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 第二种实现线程方法： 实现 Runnable 接口
 */
class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 50 ; i++) {
            System.out.println(Thread.currentThread().getName()+"-"+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
