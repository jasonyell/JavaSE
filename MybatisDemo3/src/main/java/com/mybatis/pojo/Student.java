package com.mybatis.pojo;

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
}
