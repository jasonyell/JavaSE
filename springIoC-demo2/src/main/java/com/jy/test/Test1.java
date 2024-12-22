package com.jy.test;

import com.jy.beans.Student;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @program: springIoC-demo2
 * @description
 * @author: JasonYell
 * @create: 2024-08-12 01:44
 **/
public class Test1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("====================================");

        Student stu1 = (Student) context.getBean("stu");

        System.out.println(stu1);

    }
}
