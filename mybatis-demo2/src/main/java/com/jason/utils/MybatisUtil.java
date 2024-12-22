package com.jason.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @program: mybatis-demo2
 * @description
 * @author: JasonYell
 * @create: 2023-06-07 02:03
 **/
public class MybatisUtil {
    private static SqlSessionFactory factory;
    private static final ThreadLocal<SqlSession> local = new ThreadLocal<SqlSession>();

    static {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            factory = new SqlSessionFactoryBuilder().build(is);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory(){
        return factory;
    }


    private static SqlSession getSqlSession(boolean isAutoCommit){
        SqlSession sqlSession = local.get();
        if(sqlSession == null){
            sqlSession = factory.openSession(isAutoCommit);
            local.set(sqlSession);
        }
        return sqlSession;
    }

    public static SqlSession getSqlSession(){
        return getSqlSession(false);
    }

    public static <T extends Object> T getMapper(Class<T> c){
        return getSqlSession(true).getMapper(c);
    }

}
