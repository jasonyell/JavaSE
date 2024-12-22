package com.introspector;

import org.junit.Test;

/**
 * @program: ReflectionDemo
 * @description
 * @author: JasonYell
 * @create: 2023-03-07 01:06
 **/
public class BeanTest {
    @Test
    public void getBean(){
        Config bean = (Config) BeanFactory.getBean("bean.name");
        System.out.println(bean);
        bean.toString();
    }
}
