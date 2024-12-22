package com.jy.DAO;

import org.springframework.stereotype.Component;

/**
 * @program: spring-aop-demo3
 * @description
 * @author: JasonYell
 * @create: 2024-08-18 17:15
 **/
@Component
public class UserDaoImpl {

    public void addUser(){
        System.out.println("print---addUser");
    }

}
