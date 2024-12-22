package com.jyweb.controller;

import com.jyweb.bean.User;
import com.jyweb.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @program: ssm-demo1
 * @description
 * @author: JasonYell
 * @create: 2024-09-05 02:07
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/login")
    public String login(String userName, String userPwd, HttpServletRequest request){
        User user = userService.checkLogin(userName, userPwd);

        if(user == null){
            request.setAttribute("tips","用户名&密码错误");
            return "/login.jsp";
        }else{
            request.getSession().setAttribute("user",user);
            return "redirect:/index.jsp";
        }


    }
}
