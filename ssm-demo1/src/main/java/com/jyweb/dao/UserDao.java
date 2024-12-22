package com.jyweb.dao;

import com.jyweb.bean.User;
import org.springframework.stereotype.Component;

/**
 * @program: ssm-demo1
 * @description
 * @author: JasonYell
 * @create: 2024-09-04 01:24
 **/
public interface UserDao {
    public User queryUserByName(String userName);
}
