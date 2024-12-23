package com.jason.ui;

import com.jason.bean.User;
import com.jason.service.UserService;
import com.jason.service.impl.UserServiceImpl;
import com.jason.utils.BusinessException;

/**
 * @program: ClothesSupermarketSystem
 * @description
 * @author: JasonYell
 * @create: 2023-03-20 00:58
 **/
public class LoginClass extends BaseClass{

    private UserService userService;

    public LoginClass(){
        userService = (UserService) beanFactory.getBean("userService");
    }

    public void login() throws BusinessException {
        print(getString("input.username"));
        String username = input.nextLine();
        print(getString("input.password"));
        String password = input.nextLine();

        //        UserIO userIO = new UserIO();
//        User user = userIO.findByUsernameAndPassword(username, password);

//        UserService userService = new UserServiceImpl();
        User user = userService.login(username, password);

        if (user!=null){
            currUser = user;
        }else{
            throw new BusinessException("login.error");
        }

    }
}
