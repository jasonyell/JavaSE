package com.jason.dao;

import com.jason.pojo.Course;

/**
 * @program: mybatis-demo2
 * @description
 * @author: JasonYell
 * @create: 2023-06-16 22:35
 **/
public interface CourseDao {
    public Course queryCourse(int courseId);
    public Course queryCourse1(int courseId);
}
