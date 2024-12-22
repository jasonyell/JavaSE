package com.jason.dao;

import com.jason.pojo.Users;

/**
 * @program: mybatis-demo2
 * @description
 * @author: JasonYell
 * @create: 2023-06-09 01:56
 **/
public interface UserDao {

    public int insertUser(Users users);
    public int insertUser1(Users users);

    public Users queryUser(String username);
}
