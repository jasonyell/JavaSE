package com.jason.dao;

import com.jason.pojo.Student;
import com.jason.utils.MybatisUtil;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @program: mybatis-demo2
 * @description
 * @author: JasonYell
 * @create: 2023-06-16 02:08
 **/
public class StudentDaoTest {
    @Test
    public void testQueryStudent(){
        StudentDao studentDao = MybatisUtil.getMapper(StudentDao.class);
        List<Student> students = studentDao.listStudentByCid(1);
        System.out.println(students);
    }

    @Test
    public void restQueryStudentBySid(){
        StudentDao studentDao = MybatisUtil.getMapper(StudentDao.class);
        Student student = studentDao.queryStudentBySid("10001");
        System.out.println(student);
    }

    @Test
    public void restQueryStudentBySid1(){
        StudentDao studentDao = MybatisUtil.getMapper(StudentDao.class);
        Student student = studentDao.queryStudentBySid("10001");
        System.out.println(student);
    }
}