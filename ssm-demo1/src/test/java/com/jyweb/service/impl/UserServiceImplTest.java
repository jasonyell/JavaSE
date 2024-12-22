package com.jyweb.service.impl;

import com.jyweb.bean.User;
import com.jyweb.service.UserService;
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
 * @create: 2024-09-05 02:01
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml","classpath:spring-mvc.xml","classpath:spring-mybatis.xml"})
public class UserServiceImplTest {

    @Resource
    private UserService userService;

    @Test
    public void checkLogin() {
        User user = userService.checkLogin("jason1", "1234");
        assertNotNull(user);

    }
}