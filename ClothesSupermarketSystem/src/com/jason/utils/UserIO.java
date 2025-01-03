package com.jason.utils;

import com.jason.bean.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: ClothesSupermarketSystem
 * @description
 * @author: JasonYell
 * @create: 2023-03-20 00:32
 **/
public class UserIO {

    private static List<User> users = new ArrayList<>();

    private static final String USER_FILE="user.obj";


    // 写入用户列表
    public boolean writerUsers() throws BusinessException {

        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(
                    new FileOutputStream(USER_FILE));
            out.writeObject(users);
            out.close();
        } catch (IOException e) {
            new BusinessException("io.read.error");
        }
        return true;
    }
    // 读取用户列表
    public boolean readUsers() throws BusinessException{
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(USER_FILE));
            users = (List<User>) in.readObject();
            in.close();
            return true;
        } catch (IOException | ClassNotFoundException e) {
            throw new BusinessException("io.writer.error");
        }
    }
    // 添加用户
    public void add(User user){
        user.setId(users.size()+1);
        users.add(user);
    }

    public User findByUsernameAndPassword(String username,String password){
        for(User u :users){
            if(u.getUsername().equals(username) && u.getPassword().equals(password)){
                return u;
            }
        }
        return null;
    }

}
