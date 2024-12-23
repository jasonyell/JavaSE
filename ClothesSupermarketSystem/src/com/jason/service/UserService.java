package com.jason.service;

import com.jason.bean.User;
import com.jason.utils.BusinessException;

/**
 * @program: ClothesSupermarketSystem
 * @description
 * @author: JasonYell
 * @create: 2023-03-20 00:30
 **/
public interface UserService {

    public User register(User user) throws BusinessException;

    public User login(String username, String password) throws BusinessException;

}
