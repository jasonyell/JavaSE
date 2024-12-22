package com.jason.dao;

import com.jason.pojo.Course;
import com.jason.utils.MybatisUtil;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @program: mybatis-demo2
 * @description
 * @author: JasonYell
 * @create: 2023-06-16 22:46
 **/
public class CourseDaoTest {
    @Test
    public void testQueryCourse(){
        CourseDao courseDao = MybatisUtil.getMapper(CourseDao.class);
        Course course = courseDao.queryCourse(1);
        System.out.println(course);
    }

    @Test
    public void testQueryCourse1(){
        CourseDao courseDao = MybatisUtil.getMapper(CourseDao.class);
        Course course = courseDao.queryCourse1(1);
        System.out.println(course);
    }

}