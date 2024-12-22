package com.jyweb.utils;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * @program: springMVC-demo2
 * @description
 * @author: JasonYell
 * @create: 2024-09-03 23:54
 **/
public class MyInterceptor2 implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("这是预处理2");

        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("tips","这是通过拦截器2的后处理添加的数据");

        System.out.println("这是后处理2");

    }
}
