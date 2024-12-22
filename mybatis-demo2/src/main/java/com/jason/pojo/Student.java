package com.jason.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @program: mybatis-demo2
 * @description
 * @author: JasonYell
 * @create: 2023-06-16 01:15
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
    private String stuId; // 学号
    private String stuName;
    private int stuAge;
//    private int stuCid; // 学生所在班级ID
    private Clazz clazz;

    private List<Course> courses; // 学生选择的课程
}
