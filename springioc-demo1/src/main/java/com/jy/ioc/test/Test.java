package com.jy.ioc.test;

import com.jy.ioc.beans.Student;

import java.util.Date;

/**
 * @program: springioc-demo1
 * @description
 * @author: JasonYell
 * @create: 2024-08-10 02:11
 **/
public class Test {
    public static void main(String[] args) {
        // 创建对象
        Student student = new Student();
//        // 属性赋值
//        student.setStuNum("10001");
//        student.setStuName("jason");
//        student.setStuGender("man");
//        student.setStuAge(30);
//        student.setEnterenceTime(new Date());

        System.out.println(student);
    }
}
