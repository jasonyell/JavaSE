package com.jyweb.controllers;

import com.jyweb.beans.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: springMVC-demo
 * @description
 * @author: JasonYell
 * @create: 2024-08-26 00:24
 **/
@Controller
@RequestMapping("/test")
public class TestController {

    // 表单提交的多个数据，在控制器方法中可以使用对象接受，但是提交对象的key，必须与对象属性名一致
    @RequestMapping("/add")
    public String addBook(Book book){

        System.out.println(book);
        return "tips";
    }

}
