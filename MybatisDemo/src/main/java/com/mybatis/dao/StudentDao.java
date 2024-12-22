package com.mybatis.dao;

import com.mybatis.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: MybatisDemo
 * @description
 * @author: JasonYell
 * @create: 2023-05-28 20:10
 **/

public interface StudentDao {

    /**
     * 在Mybatis进行条件查询操作：
     *  1.如果操作方法只有一个简单类型或者字符串类型参数，在mapper配置中，可直接#{str}直接获取
     *  2.如果操作方法有一个对象类型参数，在mapper配置中可以直接通过#{attrName}获取对象的指定属性值（attrName必须是参数对象属性）
     *  3.如果操作方法有一个Map类型的参数，在mapper配置中可以直接通过#{key}获取key对应的value
     *  4.如果操作方法有多个参数，如何处理？
     *
     * @param student
     * @return
     */

    public int insertStudent(Student student);
    public int deleteStudent(String stuNum);
    public int updateStudent(Student student);
    public List<Student> listStudent();
    public Student queryStudent(String Num);
//    public List<Student> listStudentByPage(@Param("start") int start,
//                                           @Param("pageSize") int pageSize);
    public int countStudent();

    public List<Student> listStudentsByGender(String gender);
}
