package com.jason.dao;

import com.jason.pojo.Detail;
import com.jason.pojo.Users;
import com.jason.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @program: mybatis-demo2
 * @description
 * @author: JasonYell
 * @create: 2023-06-09 02:06
 **/
public class UserDaoTest {

    @Test
    public void testInsertUser() {
        // 用户注册，提交了基本信息和详情到servlet，servlet接收到信息封装到User和Detail对象
        Users user = new Users(0, "jason", "12342", "yell3", "03.jpg",null);
        Detail detail = new Detail(0,"西安市碑林区","18792953881","没个性签名",0);

        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try{
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            int i = userDao.insertUser(user);
            detail.setUserId(user.getUserId());

            DetailDao detailDao = sqlSession.getMapper(DetailDao.class);
            int i1 = detailDao.insertDetail(detail);

            System.out.println(i+i1);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }
    }

    @Test
    public void testQueryUser(){
        UserDao userDao = MybatisUtil.getMapper(UserDao.class);
        Users user = userDao.queryUser("jason");
        System.out.println(user);
    }

    @Test
    public void testQueryUserByUserId(){
        DetailDao detailDao = MybatisUtil.getMapper(DetailDao.class);
        Detail queryDetailByUserId = detailDao.queryDetailByUserId(2);
        System.out.println(queryDetailByUserId);
    }

}