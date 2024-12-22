package com.jyweb.utils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @program: springMVC-demo2
 * @description
 * @author: JasonYell
 * @create: 2024-09-02 01:15
 **/
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public String nullHandle(){
        return "/err1.jsp";
    }

    @ExceptionHandler(NumberFormatException.class)
    public String formatHandle(){
        return "/err2.jsp";
    }

}
