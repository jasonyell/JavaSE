package com.AOP;

import org.junit.Test;

import java.io.InputStream;

/**
 * @program: ReflectionDemo
 * @description
 * @author: JasonYell
 * @create: 2023-03-07 01:46
 **/
public class AOPTest {
    @Test
    public void test(){
        // 读取配置文件
        InputStream in = Thread.currentThread().getContextClassLoader().
                getResourceAsStream("com/AOP/bean.properties");

        // 创建bean的工厂对象
        BeanFactory beanFactory = new BeanFactory(in);
        // 获取代理对象
        ProxyFactoryBean proxyFactoryBean = (ProxyFactoryBean) beanFactory.getBean("bean");
        IManager proxy = (IManager) proxyFactoryBean.getProxy();
        proxy.add("jason");
    }
}
