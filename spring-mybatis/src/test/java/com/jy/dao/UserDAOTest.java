package com.jy.dao;

import com.jy.pojo.User;
import com.jy.service.UserService;
import com.jy.service.impl.UserServiceImpl;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @program: spring-mybatis
 * @description
 * @author: JasonYell
 * @create: 2024-08-19 01:16
 **/

public class UserDAOTest {

    @Test
    public void queryUsers() {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");


//        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) context.getBean("sqlSessionFactory");
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        UserDAO userDAO = sqlSession.getMapper(UserDAO.class);

        UserDAO userDAO = (UserDAO) context.getBean("userDAO");

        List<User> users = userDAO.queryUsers();
        for (User user: users) {
            System.out.println(user.toString());
        }

    }

    @Test
    public void queryUsers2(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl userService = (UserServiceImpl) context.getBean("userServiceImpl");
        List<User> users = userService.listUsers();
        for (User u : users) {
            System.out.println(u.toString());
        }
    }

    @Test
    public void insertUser(){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl userService = (UserServiceImpl) context.getBean("userServiceImpl");

        User user = new User(3,"jason5","1234","admin","jason_img");
        int i = userService.insertUser(user);
        System.out.println(i);
    }

}
