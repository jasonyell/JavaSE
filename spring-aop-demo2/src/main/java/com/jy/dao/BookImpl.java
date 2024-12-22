package com.jy.dao;

import com.jy.Proxy.GenaralDAO;

/**
 * @program: spring-aop-demo2
 * @description
 * @author: JasonYell
 * @create: 2024-08-17 02:39
 **/
public class BookImpl  {
    public void search() {
        System.out.println("-------------search");

    }

    public void delete() {
        System.out.println("-------------delete");
    }

    public void update() {
        System.out.println("-------------update");
    }

    public void insert() {
        System.out.println("-------------insert");
//        throw new NullPointerException();
    }
}
