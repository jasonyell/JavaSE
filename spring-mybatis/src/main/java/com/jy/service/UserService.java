package com.jy.service;


import com.jy.pojo.User;

import java.util.List;

/**
 * @program: spring-mybatis
 * @description
 * @author: JasonYell
 * @create: 2024-08-19 01:43
 **/
public interface UserService {

     public List<User> listUsers();

     public int insertUser(User user);

}
