package com.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


/**
 * @program: MybatisDemo
 * @description
 * @author: JasonYell
 * @create: 2023-06-04 23:55
 **/
public class MyBatisUtil {

    private static SqlSessionFactory factory;
    // 线程锁
    private static final ThreadLocal<SqlSession> local = new ThreadLocal<SqlSession>();

    static {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

            factory = sqlSessionFactoryBuilder.build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 私有化封装SqlSession
    private static SqlSession getSqlSession(boolean isAutoCommit){
        SqlSession session = local.get();
        if(session == null){
            // 通过 SqlSessionFactory 调用openSession方法获取sqlSession对象时，可以通过设置食物是否自动提交
            // 如果参数设置为true,表示自动提交 factory.openSession(true);
            // 参数如果为false或者空，表示手动提交
            session = factory.openSession(isAutoCommit);
            local.set(session);
        }
        return session;
    }

    public static SqlSessionFactory getFactory(){
        return factory;
    }

    // 对外提供 手动提交的SqlSession 的接口
    public static SqlSession getSqlSession(){
        return getSqlSession(false);
    }

    public static <T extends Object> T getMapper(Class<T> c){
        SqlSession sqlSession = getSqlSession(true);
        return sqlSession.getMapper(c);
//        return null;
    }
}
