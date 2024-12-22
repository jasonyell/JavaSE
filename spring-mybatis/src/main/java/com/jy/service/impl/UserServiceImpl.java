package com.jy.service.impl;

import com.jy.dao.UserDAO;
import com.jy.pojo.User;
import com.jy.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: spring-mybatis
 * @description
 * @author: JasonYell
 * @create: 2024-08-19 01:43
 **/

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDAO userDAO;

    public List<User> listUsers() {
        return userDAO.queryUsers();
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ ,propagation = Propagation.SUPPORTS )
    public int insertUser(User user) {
        return userDAO.insertUser(user);
    }

}
