package com.mybatis.dao;

import com.mybatis.pojo.Clazz;
import com.mybatis.utils.MyBatisUtil;
import org.junit.Test;

/**
 * @program: Mybatis-Demo3
 * @description
 * @author: JasonYell
 * @create: 2023-09-21 01:54
 **/
public class ClazzDAOTest {

    @Test
    public void queryClassById(){
        ClazzDAO clazz = MyBatisUtil.getMapper(ClazzDAO.class);
        Clazz clazz1 = clazz.queryClassByCid(1);
        System.out.println(clazz1.getClassName());
//        System.out.println(clazz1);
        System.out.println("----------------------------------");
        System.out.println(clazz1.getStus());
    }

}