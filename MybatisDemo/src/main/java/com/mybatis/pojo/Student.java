package com.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @program: MybatisDemo
 * @description
 * @author: JasonYell
 * @create: 2023-05-28 20:04
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {

    private int stuId;
    private String stuNum;
    private String stuName;
    private String stuGender;
    private int stuAge;

}
