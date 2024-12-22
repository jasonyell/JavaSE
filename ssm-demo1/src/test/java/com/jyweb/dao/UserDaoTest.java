package com.jyweb.dao;

import com.jyweb.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @program: ssm-demo1
 * @description
 * @author: JasonYell
 * @create: 2024-09-04 02:43
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml","classpath:spring-mvc.xml","classpath:spring-mybatis.xml"})
public class UserDaoTest {

    @Resource
    private UserDao userDao;

    @Test
    public void queryUserByName() {
        User jason1 = userDao.queryUserByName("jason1");
        System.out.println(jason1);
    }
}