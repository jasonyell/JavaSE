package com.AOP;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @program: ReflectionDemo
 * @description
 *  AOP 框架简单实现
 * @author: JasonYell
 * @create: 2023-03-07 01:33
 **/
public class BeanFactory {

    Properties prop = new Properties();

    public BeanFactory(InputStream in){
        try {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取一个BEAN实例
     * @param name
     * @return
     */
    public Object getBean(String name){
        String className = prop.getProperty(name);
        Object bean = null;
        try {
            // 获取ProxyFactoryBean的 class对象
            Class<?> aClass = Class.forName(className);
            // 实例化对象
            bean=aClass.newInstance();
            // 根据配置文件实例化target 和 advice对象
            Object target = Class.forName(prop.getProperty(name + ".target")).newInstance();
            Object advice = Class.forName(prop.getProperty(name + ".advice")).newInstance();
            // 通过类型实现对ProxyFactoryBean的属性赋值
            BeanInfo beanInfo = Introspector.getBeanInfo(aClass);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor pd: propertyDescriptors) {
                String name1 = pd.getName();
                Method writeMethod = pd.getWriteMethod();
                if("target".equals(name1)){
                    writeMethod.invoke(bean,target);
                }else if("advice".equals(name1)){
                    writeMethod.invoke(bean,advice);
                }
            }

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IntrospectionException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }
}
