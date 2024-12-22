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
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Clazz {
    private int classId;
    private String className;
    private String classDesc;

    private List<Student> stus;
}
