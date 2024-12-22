package com.jy.utils;

/**
 * @program: spring-aop-demo2
 * @description
 * @author: JasonYell
 * @create: 2024-08-18 01:12
 **/
public class TxManager {

    public void begin(){
        System.out.println("Start---Commit Control");
    }

    public void commit(){
        System.out.println("End---Commit Control");
    }
}
