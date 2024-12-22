package com.mybatis.dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mybatis.pojo.Student;
import com.mybatis.utils.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @program: MybatisDemo
 * @description
 * @author: JasonYell
 * @create: 2023-05-29 00:02
 **/
public class StudentDaoTest {

    @Test
    public void insertStudent() {
        // 1.当我们获取SqlSession对象时，就默认开启了事务
        SqlSession sqlSession = MyBatisUtil.getSqlSession();

        try {
            // 通过会话获取DAO对象
            StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
            // 通过StudentDao中的方法
            Student student = new Student(0, "10008", "lily", "女", 22);
            int i = studentDao.insertStudent(student);
            // 2.事务提交 需要手动提交
            sqlSession.commit();

            System.out.println(student);

        } catch (Exception e) {
//            3. 当操作出现异常调用rollback进行回滚
            sqlSession.rollback();
        }


    }

    @Test
    public void testDeleteStudent() {

//        SqlSessionFactory factory = null;
//        // 默认  factory.openSession(boolean isAutoCommit);
//        SqlSession sqlSession = factory.openSession();
//        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
        int i = studentDao.deleteStudent("10001");

    }

    @Test
    public void testUpdateStudent(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(is);
            SqlSession session = factory.openSession();
            StudentDao studentDao = session.getMapper(StudentDao.class);
            int i = studentDao.updateStudent(new Student(0, "10002", "jason", "女", 22));
            // assertEquals(期望值，实际值) 断言判断
            assertEquals(1,i);
            session.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testSelectStudent(){

        StudentDao dao = MyBatisUtil.getMapper(StudentDao.class);
        List<Student> students = dao.listStudent();
//            assertNotNull(students);
//            System.out.println(students.toString());

        for (Student s: students) {
            System.out.println(s);
        }

    }

    @Test
    public void testQueryStudent(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = builder.build(is);
            SqlSession session = sqlSessionFactory.openSession();
            StudentDao queryStudent = session.getMapper(StudentDao.class);
            Student student = queryStudent.queryStudent("10002");
            System.out.println(student.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListStudentByPage(){
//        try {
////            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
////            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
////            SqlSessionFactory factory = builder.build(is);
////            SqlSession session = factory.openSession();
////            StudentDao studentDao =  session.getMapper(StudentDao.class);
////            List<Student> students = studentDao.listStudentByPage(1,3);
////            for (Student s: students) {
////                System.out.println(s);
////            }
////        } catch (IOException e) {
////
////            e.printStackTrace();
////        }
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
        // 执行查询前设置分页拦截器
        PageHelper.startPage(1,4);
//        List<Student> students = studentDao.listStudent();
        List<Student> students = studentDao.listStudentsByGender("男");
        // 封装分页数据 可以返回前端数据
        PageInfo<Student> pageInfo = new PageInfo<Student>(students);

        List<Student> studentList = pageInfo.getList();
        for (Student s: studentList) {
            System.out.println(s);
        }
    }

    @Test
    public void testCountStudent(){

            SqlSession sqlSession = MyBatisUtil.getSqlSession();
            StudentDao studentDao =  sqlSession.getMapper(StudentDao.class);
            int i = studentDao.countStudent();
            System.out.println(i);

    }
}