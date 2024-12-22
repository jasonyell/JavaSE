package com.jyweb.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jyweb.beans.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: springMVC-demo
 * @description
 * @author: JasonYell
 * @create: 2024-08-20 23:44
 **/
@Controller
@RequestMapping("/book")
public class BookController {

//    <form action="/Book/add" method="post">
//        <p>图书名称：<input type="text" name="name"></p>
//        <p>图书作者：<input type="text" name="author"></p>
//        <p>图书价格：<input type="text" name="price"></p>
//        <p><input type="submit" value="提交"></p>
//    </form>


    /** 接收请求行数据
    @RequestMapping("/add")
    public void add(@RequestParam("name") String a,
                    @RequestParam("author")String b,
                    @RequestParam("price") double c){
        System.out.println(a+" "+b+" "+c);
        System.out.println("Book add");
    }*/

    @RequestMapping("/add2")
    public ModelAndView add2(String name, String author, double price){

        ModelAndView mav = new ModelAndView("/tips.jsp");
        mav.addObject("key2","value2");
        mav.addObject("book",new Book(2,"WAHAHAH","YELL",22.3));

        return mav;
    }

    @RequestMapping("/add")
    public String add(String name, String author, double price, Model model){
        model.addAttribute("key1","value1");
        model.addAttribute("book",new Book(0,"jason","yell",12.2));

//        如何跳转到指定的页面呢？
//        return "/tips.jsp"; // 类上有路径 需要加上 /
        return "tips";
    }

    @RequestMapping("/list")
    private void list(@RequestHeader("token") String token){
        System.out.println("Book list");
    }


//    private void update(HttpServletRequest request){
    @RequestMapping("/update")
    @ResponseBody
    private List<Book> update() throws IOException {
        System.out.println("Book update");

    /**
        try {
            // 使用request输入流请求数据 servlet中接收方式
            ServletInputStream is= request.getInputStream();
            StringBuffer stringBuffer = new StringBuffer();
            byte[] bs = new byte[100];
            int len = -1;
            while ((len = is.read(bs)) !=-1){
                String s = new String(bs,0,len);
                stringBuffer.append(s);
            }
            System.out.println(stringBuffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
     */

        /**
        // 使用ObjectMapper将对象转换成JSON格式字符串
        String s = new ObjectMapper().writeValueAsString(book);
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        out.println(s);
        out.flush();
        out.close();

        */

        List<Book> books = new ArrayList<Book>();
        books.add(new Book(0,"jason","yell",12.2));
        books.add(new Book(1,"jason","yell2",13.2));

        System.out.println(books);

        return books;
    }


}
