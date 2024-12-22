package com.jyweb.service.impl;

import com.jyweb.bean.User;
import com.jyweb.dao.UserDao;
import com.jyweb.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @program: ssm-demo1
 * @description
 * @author: JasonYell
 * @create: 2024-09-05 01:57
 **/
@Service
public class UserServiceImpl implements UserService  {

    @Resource
    private UserDao userDao;

    @Transactional
    public User checkLogin(String userName, String userPwd) {
        User user = userDao.queryUserByName(userName);

        // 如果不嫌判断user 是非为空本地方法会先报空指针
        if (user == null){
            return null;
        }
        // 加密
        if(user.getUserPwd().equals(userPwd)){
            return user;
        }else{
            return null;
        }
    }
}
