package com.jason;

import org.junit.Test;

/**
 * @program: RegexDemo
 * @description
 *  正则表达式
 * @author: JasonYell
 * @create: 2023-03-09 23:31
 **/
public class RegexDemo2 {
    @Test
    public void test(){
        String s1 = "010-38389438";
        boolean b = s1.matches("\\d{3,4}-\\d{7,8}");
        System.out.println("匹配电话号码："+b);

        String s2 = "18792953881";
        // [1][3-9]\d{9} -> 第一位是1 第二位是3-9 后9位为数字
        boolean b1 = s2.matches("[1][3-9]\\d{9}");
        System.out.println("匹配手机号码: "+b1);

        // 匹配用户名：字母开头，数字字母下划线组合
        String s3 = "abc1314";
        System.out.println(s3.matches("[a-z][A-Z]+[\\w|_]*"));

        // 匹配IP地址
        String s4 = "20.132.143.22";
        System.out.println(s4.matches("\\d{1,3}.\\d{1,3}.\\d{1,3}.\\d{1,3}"));

        // 匹配网址
        String s5 = "http://www.baidu.com";
        System.out.println(s5.matches("http://\\w+.\\w+.\\S*"));

        // 匹配年龄
        String s6 = "16";
        // 限制年龄3位数
        System.out.println(s6.matches("\\d{1,3}"));

        // 匹配金额
        String s7 = "19.8";
        System.out.println(s7.matches("\\d+.\\d+"));



    }
}
