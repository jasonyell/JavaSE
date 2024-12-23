package com.jason.ui;

import com.jason.bean.User;
import com.jason.service.UserService;
import com.jason.service.impl.UserServiceImpl;
import com.jason.utils.BusinessException;

/**
 * @program: ClothesSupermarketSystem
 * @description
 * @author: JasonYell
 * @create: 2023-03-20 00:23
 **/
public class RegisterClass extends BaseClass {

    private UserService userService;

    public RegisterClass(){
        userService = (UserService) beanFactory.getBean("userService");
    }

    public void register() throws BusinessException {
        print(getString("input.username"));
        String username = input.nextLine();

        print(getString("input.password"));
        String password = input.nextLine();

        User user = new User(username,password);
//        UserService userService = new UserServiceImpl();
        userService.register(user);
    }

}
