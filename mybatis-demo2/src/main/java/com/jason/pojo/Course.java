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
 * @create: 2023-06-16 22:22
 **/
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private int courseId;
    private String courseName;
    private List<Student> students;
}
