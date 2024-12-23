package com.jason.service.impl;

import com.jason.bean.User;
import com.jason.service.UserService;
import com.jason.utils.BusinessException;
import com.jason.utils.EmptyUtils;
import com.jason.utils.UserIO;

/**
 * @program: ClothesSupermarketSystem
 * @description
 * @author: JasonYell
 * @create: 2023-03-20 00:31
 **/
public class UserServiceImpl implements UserService {
    @Override
    public User register(User user) throws BusinessException {
        UserIO userIO = new UserIO();

        userIO.add(user);
        userIO.writerUsers();
        return null;
    }

    @Override
    public User login(String username, String password) throws BusinessException {
        if(EmptyUtils.isEmpty(username)){
            throw new BusinessException("username.notnull");
        }
        if(EmptyUtils.isEmpty(password)){
            throw new BusinessException("password.notnull");
        }

        UserIO userIO = new UserIO();
        User user = userIO.findByUsernameAndPassword(username, password);

        return user;
    }
}
