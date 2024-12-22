package com.jyweb.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: springMVC-demo
 * @description
 * @author: JasonYell
 * @create: 2024-08-26 00:58
 **/

/**
 * 1. 创建一个类实现Converter<1,2>接口，泛型指定从1类型转换到2类型
 * 2. 实现convert方法
 */
public class MyDateConverter implements Converter<String, Date> {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");


    public Date convert(String s) {
        Date date = null;

        try {
            date = sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }
}
