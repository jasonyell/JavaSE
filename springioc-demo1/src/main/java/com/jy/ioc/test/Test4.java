package com.jy.ioc.test;

import com.jy.ioc.beans.Book;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: springioc-demo1
 * @description
 * @author: JasonYell
 * @create: 2024-08-11 23:51
 **/
public class Test4 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Book book1 = (Book) context.getBean("book");
        Book book2 = (Book) context.getBean("book");

        System.out.println(book1+" "+book2);
    }
}
