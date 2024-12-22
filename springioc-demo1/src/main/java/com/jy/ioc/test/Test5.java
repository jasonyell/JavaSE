package com.jy.ioc.test;

import com.jy.ioc.servlet.TestServlet;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: springioc-demo1
 * @description
 * @author: JasonYell
 * @create: 2024-08-12 00:39
 **/
public class Test5 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        TestServlet testServlet = (TestServlet) context.getBean("testServlet");

        testServlet.doPost();
    }
}
