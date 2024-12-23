package com.jason;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: RegexDemo
 * @description
 * @author: JasonYell
 * @create: 2023-03-09 23:13
 **/
public class RegexDemo {

    @Test
    public void test3(){
        String s = "5201314";
        // 如果没有+ 则是false 指一个
        boolean b1 = s.matches("[0-9]+");
        boolean b2 = s.matches("\\d+");
        System.out.println(b1+"-"+b2);

    }

    @Test
    public void test2(){
        // 创建一个匹配模式(模板)
        Pattern p = Pattern.compile("a*b");
        Matcher val1 = p.matcher("sb");
        boolean matches = val1.matches(); // 匹配
        System.out.println(matches);
    }


    /**
     * 未使用正则表达式检测字符串是否由数组组成
     */
    @Test
    public void test1(){
        String s = "5201314";

        char[] chars = s.toCharArray();
        boolean flag = true;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]<'0' || chars[i]<'9'){
                flag = false;
                break;
            }
        }
        if(false){
            System.out.println("由数字组成");
        }else{
            System.out.println("是数字组成");
        }
    }
}
