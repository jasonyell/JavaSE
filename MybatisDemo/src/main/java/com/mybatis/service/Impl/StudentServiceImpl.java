package com.mybatis.service.Impl;

import com.mybatis.service.StudentService;
import com.mybatis.dao.StudentDao;
import com.mybatis.pojo.Student;
import com.mybatis.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @program: MybatisDemo
 * @description
 * @author: JasonYell
 * @create: 2023-06-05 01:27
 **/
public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

    public boolean addStudent(Student student) {
        boolean b = false;
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try{
            int i = studentDao.insertStudent(student);
            b = i > 0;
            sqlSession.commit();
        }catch (Exception e){
            sqlSession.rollback();
        }
        return b;
    }

    public List<Student> listStudent(){
        List<Student> students = studentDao.listStudent();
        return students;
    }


}
