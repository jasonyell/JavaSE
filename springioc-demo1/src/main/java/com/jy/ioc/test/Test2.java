package com.jy.ioc.test;

import com.jy.ioc.beans.Book;
import com.jy.ioc.beans.Student;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * @program: springioc-demo1
 * @description
 * @author: JasonYell
 * @create: 2024-08-10 02:14
 **/
public class Test2 {
    public static void main(String[] args) {
        // 通过spring容器创建对象
        // 1. 初始化spring容器,加载spring配置文件
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        // 当spring容器进行初始化的时候，就会加载并解析这个配置文件（dom4j）：把配置文件中的内容读取出来，存放到一个Java对象中
        //


        // 2. 通过spring容器，获取student对象
        Student stu = (Student) context.getBean("stu2");

        System.out.println(stu);


//        Book book = (Book) context.getBean("book");
//        System.out.println(book);

//        Date date = (Date) context.getBean("date");
//        System.out.println(date);

    }
}
