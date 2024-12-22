package com.jy.Test;

import com.jy.DAO.UserDaoImpl;
import org.springframework.context.index.CandidateComponentsIndexLoader;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: spring-aop-demo3
 * @description
 * @author: JasonYell
 * @create: 2024-08-18 17:15
 **/
public class test {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDaoImpl userDaoImpl = (UserDaoImpl) context.getBean("userDaoImpl");
        userDaoImpl.addUser();
}
}
