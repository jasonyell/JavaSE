package com.jason.ui;

import com.jason.utils.BusinessException;
import com.jason.utils.UserIO;

/**
 * @program: ClothesSupermarketSystem
 * @description
 * @author: JasonYell
 * @create: 2023-03-20 00:14
 **/
public class WelcomeClass extends BaseClass {
    public void start(){
        print(getString("info.welcome"));

        UserIO userIO = new UserIO();
        userIO.readUsers();

        boolean flag = true;

        while (flag){
            print(getString("info.login.reg"));
            print(getString("info.select"));

            String select = input.nextLine();

            switch (select){
                case "1":
//                    System.out.println("登录");
                    try {
                        new LoginClass().login();
                        flag=false;
                        print(getString("login.success"));
                    } catch (BusinessException e) {
                        print(getString("login.error"));
                    }
                    break;
                case "2":
//                    System.out.println("注册");
                    try {
                        new RegisterClass().register();
                        flag=false;
                        print(getString("reg.success"));
                    } catch (BusinessException e) {
                        print(getString("reg.error"));
                    }
                    break;
                default:
                    print(getString("input.error"));
                    flag=true;
                    break;
            }
        }
        HomeClass homeClass = new HomeClass();
        homeClass.show();
    }
}
