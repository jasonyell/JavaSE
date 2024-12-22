package com.mybatis.servlet;

import com.mybatis.service.Impl.StudentServiceImpl;
import com.mybatis.service.StudentService;

/**
 * @program: MybatisDemo
 * @description
 * @author: JasonYell
 * @create: 2023-09-20 01:29
 *
 * web 项目依赖引入jar: jsp servlet-api
 **/

@javax.servlet.annotation.WebServlet("/TestServlet")
public class TestServlet extends javax.servlet.http.HttpServlet {

    private StudentService studentService = new StudentServiceImpl();

    protected void doPost(javax.servlet.http.HttpServlet request, javax.servlet.http.HttpServletResponse response){

    }

    protected void doGet(javax.servlet.http.HttpServlet request, javax.servlet.http.HttpServletResponse response){

    }
}
