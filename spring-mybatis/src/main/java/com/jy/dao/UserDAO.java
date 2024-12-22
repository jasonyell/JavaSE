package com.jy.dao;

import com.jy.pojo.User;

import java.util.List;

/**
 * @program: spring-mybatis
 * @description
 * @author: JasonYell
 * @create: 2024-08-19 00:59
 **/
public interface UserDAO {

    public List<User> queryUsers();

    public int insertUser(User user);

}
