package com.jason;

import sun.misc.FpUtils;

/**
 * @program: ThreadDemo
 * @description
 *  两个线程协同工作，先生产，在消费
 *
 *  sleep() 和 wait() 的区别？
 *      sleep ：让线程进入休眠状态，让出CPU的时间片，不释放对象监视器的所有权（对象锁）
 *      wait  : 让线程进入等待状态，让出CPU的时间片，并释放对监视器的所有权，等待其他线程通过notify方法来唤醒
 * @author: JasonYell
 * @create: 2023-02-24 02:14
 **/
public class ProducterCustomerDemo {

    public static void main(String[] args) {
        Food food = new Food();

        Customers c = new Customers(food);
        Producter p = new Producter(food);

        Thread t1 = new Thread(c);
        Thread t2 = new Thread(p);

        t1.start();
        t2.start();

    }
}

/**
 * 消费者
 */
class Customers implements Runnable{
    private Food food;
    public Customers(Food food){
        this.food=food;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            food.get();
        }
    }
}


/**
 * 生产者
 */
class Producter implements Runnable{

    private Food food;

    public Producter(Food food){
        this.food=food;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if(i%2==0){
                food.set("锅包肉","酸甜口");
            }else{
                food.set("土豆丝","麻辣");
            }
        }
    }
}

/**
 * 食物
 */
class Food{
    private String name;
    private String Desp;
    private boolean flag = true; // true表示可生产 ，false表示可消费

    /**
     * 生产
     * @param name
     * @param desp
     */
    public synchronized void set(String name, String desp){
        // 不能生产
        if(!flag){
            try {
                this.wait();   // 线程进入等待状态，释放监视器的所有权（对象锁）
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.setName(name);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setDesp(desp);
        flag = false;
        this.notify(); // 唤醒其中的一个
    }

    /**
     * 消费
     */
    public synchronized void get(){
        // 不能消费
        if(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName()+"->"+this.getDesp());
        flag = true;
        this.notify();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesp() {
        return Desp;
    }

    public void setDesp(String desp) {
        Desp = desp;
    }

    @Override
    public String toString() {
        return "food{" +
                "name='" + name + '\'' +
                ", Desp='" + Desp + '\'' +
                '}';
    }


    public Food() {
    }

    public Food(String name, String desp) {
        this.name = name;
        Desp = desp;
    }
}
