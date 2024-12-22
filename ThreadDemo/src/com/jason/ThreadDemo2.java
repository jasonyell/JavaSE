package com.jason;

/**
 * @program: ThreadDemo
 * @description
 *  join方法：
 *      加入线程，让调用的线程先执行时间或执行完毕
 *
 *  中断线程：
 *      1.使用 interrupt 方法来中断线程，设置一个中断状态（标记）
 *      2.自定义标记的方式（推荐使用）
 * @author: JasonYell
 * @create: 2023-02-23 01:15
 **/
public class ThreadDemo2 {
    public static void main(String[] args) {
        MyRunnable2 mr2 = new MyRunnable2();
        MyRunnable3 mr3 = new MyRunnable3();

        Thread mt1 = new Thread(mr2);
        Thread mt2 = new Thread(mr3);

//        mt1.start();
        mt2.start();

        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName()+"--"+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i == 10){
//                try {
//                    mt1.join(); //  让t线程执行完毕
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

//                mt1.interrupt(); // 中断线程，只是做了一个中断标记

                mr3.flag = false;
            }
        }
    }
}

class MyRunnable2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            // 测试中断状态，此方法会把中断状态清除
            if(Thread.interrupted()){
                // ....
                break;
            }

            System.out.println(Thread.currentThread().getName()+"--"+i);

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }

    }
} 

class MyRunnable3 implements Runnable{
    public boolean flag = true;

    public MyRunnable3(){
        flag = true;
    }

    @Override
    public void run() {
        int i = 0;
        while (flag){
            System.out.println(Thread.currentThread().getName()+"--"+(i++));
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}