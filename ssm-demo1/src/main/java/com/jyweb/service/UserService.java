package com.jyweb.service;

import com.jyweb.bean.User;

/**
 * @program: ssm-demo1
 * @description
 * @author: JasonYell
 * @create: 2024-09-05 01:56
 **/
public interface UserService {
    public User checkLogin(String userName, String userPwd);
}
