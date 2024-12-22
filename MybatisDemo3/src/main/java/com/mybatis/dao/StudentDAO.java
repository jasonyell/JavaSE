package com.mybatis.dao;

import com.mybatis.pojo.Student;

import java.util.List;

/**
 * @program: Mybatis-Demo3
 * @description
 * @author: JasonYell
 * @create: 2023-09-21 01:31
 **/
public interface StudentDAO {
    //根据班级编号，查询这个班级下所有的学生
    public List<Student> queryStudentByCid(int cid);
}
