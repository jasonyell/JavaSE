package com.jy.Test;

import com.jy.dao.BookImpl;
import com.jy.dao.StudentImpl;
import com.jy.service.BookServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: spring-aop-demo2
 * @description
 * @author: JasonYell
 * @create: 2024-08-17 02:43
 **/
public class Test {
    public static void main(String[] args) {
        // 通过spring容器获取bookDaoImpl的对象,并调用方法
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookImpl bookImpl = (BookImpl) context.getBean("bookDAO");
        StudentImpl studentImpl = (StudentImpl) context.getBean("studentDAO");

//        bookImpl.delete();
//        System.out.println("-----------------------------------------");
//        studentImpl.search();

        // 如果使用spring aop面向切面编程，调用切入点方法的对象必须通过spring容器获取
        // 如果一个类种方法被声明成切入点并且织如切入点后，通过spring容器获取对象，实则获取到的是一个代理对象
        // 如果一个类中的方法没被声明成切入点，通过spring容器获取的就是这个类真实创建对象
//        BookServiceImpl bookService = new BookServiceImpl();
        BookServiceImpl bookService = (BookServiceImpl) context.getBean("bookServiceImpl");
//        bookService.addBook();

        bookImpl.insert();

    }
}
