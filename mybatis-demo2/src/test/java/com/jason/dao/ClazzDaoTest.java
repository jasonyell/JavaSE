package com.jason.dao;

import com.jason.pojo.Clazz;
import com.jason.utils.MybatisUtil;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @program: mybatis-demo2
 * @description
 * @author: JasonYell
 * @create: 2023-06-16 01:52
 **/
public class ClazzDaoTest {

    @Test
    public void testQueryClass(){
        ClazzDao clazzDao = MybatisUtil.getMapper(ClazzDao.class);
        Clazz clazz = clazzDao.queryClazz(1);
        System.out.println(clazz);
    }

}