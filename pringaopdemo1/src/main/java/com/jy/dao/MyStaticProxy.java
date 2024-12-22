package com.jy.dao;

/**
 * @program: pringaopdemo1
 * @description
 * @author: JasonYell
 * @create: 2024-08-14 01:47
 **/
public class MyStaticProxy {

//    private BookDAOImpl bookDAO = new BookDAOImpl();

    private GenaralDAO dao;

    public MyStaticProxy(GenaralDAO dao) {
        this.dao = dao;
    }

    public void insert(){
        begin();
        dao.insert();
        final1();
    }

    public void search(){
        begin();
        dao.search();
        final1();
    }

    public void delete(){
        begin();
        dao.delete();
        final1();
    }


    long time1;
    long time2;

    private void begin(){
        time1 = System.currentTimeMillis();
        System.out.println("begin");
    }

    private void final1(){
        System.out.println("final");
        time2 = System.currentTimeMillis();
        System.out.println(dao.getClass().getSimpleName()+" use time:  "+ (time2 - time1));
    }
}
