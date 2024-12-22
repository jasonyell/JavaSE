package com.jason.dao;

import com.jason.pojo.Student;

import java.util.List;

/**
 * @program: mybatis-demo2
 * @description
 * @author: JasonYell
 * @create: 2023-06-16 01:19
 **/
public interface StudentDao {
    public List<Student> listStudentByCid(int cid);

    public Student queryStudentBySid(String sid);

    public Student queryStudentBySid1(String sid);

    public List<Student> queryStudentByCourseId(int courseId);


}
