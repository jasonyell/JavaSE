package com.jason;

import java.util.concurrent.*;

/**
 * @program: ThreadDemo
 * @description
 *  JDK1.5 线程池
 * @author: JasonYell
 * @create: 2023-02-27 01:19
 **/
public class ThreadDemo5 {
    public static void main(String[] args) {
        // 创建线程池（4种）
        // 创建一个单线程的线程池
//        ExecutorService es = Executors.newSingleThreadExecutor();
        // 创建一个固定大小线程池
//        ExecutorService es = Executors.newFixedThreadPool(4);

        // 创建一个可缓存的线程池。如果线程池的大小超过了处理任务所需要的线程
        // 那么就会回收部分空闲 (60秒不执行任务)的线程，当任务数增加时，此线程池又可以智能的添加新线程来处理任务。此线程池不会对线程池大小做限制
        // 线程池大小完全依赖于作系统(或者说JM)能够创建的最大线程大小。
//        ExecutorService es = Executors.newCachedThreadPool();

        //
        ScheduledExecutorService es = Executors.newScheduledThreadPool(3);

        es.execute(new MyRunnable6());
        es.execute(new MyRunnable6());

        es.schedule(new MyRunnable6(),3000, TimeUnit.MICROSECONDS);
        es.shutdown();
    }
}

class MyRunnable6 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+"run"+i);
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
