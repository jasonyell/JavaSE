package com.jy.test;

import com.jy.dao.BookDAOImpl;
import com.jy.dao.MyStaticProxy;
import com.jy.dao.StudentDAOImpl;

/**
 * @program: pringaopdemo1
 * @description
 * @author: JasonYell
 * @create: 2024-08-14 01:46
 **/
public class Test {
    public static void main(String[] args) {

        // 被代理对象
        BookDAOImpl bookDAO = new BookDAOImpl();
        StudentDAOImpl studentDAO = new StudentDAOImpl();
//        bookDAO.deleteBook();

        // 为被代理对象创建代理对象
        MyStaticProxy proxy = new MyStaticProxy(bookDAO);

        proxy.delete();

    }
}
