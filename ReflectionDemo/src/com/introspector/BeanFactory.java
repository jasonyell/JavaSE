package com.introspector;

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
 *  通过内省的API来装配一个Bean对象，Bean对象的值是通过配置文件中来获取
 *  目的是为了提高维护性
 * @author: JasonYell
 * @create: 2023-03-07 00:52
 **/
public class BeanFactory {
    private static Properties prop = new Properties();
    //使用静态代码块读取配置文件
    static {
        InputStream in = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/introspector/config.properties");
        try {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取一个Bean
     * @param name
     * @return
     */
    public static Object getBean(String name){
        Object bean = null;

        String beanName = prop.getProperty(name);
        try {
            Class<?> aClass = Class.forName(beanName);
            bean = aClass.newInstance();
            //通过类信息获取javaBean的描述信息
            BeanInfo beanInfo = Introspector.getBeanInfo(aClass);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (int i = 0; i < propertyDescriptors.length; i++) {
                String propName = propertyDescriptors[i].getName();
                Method writeMethod = propertyDescriptors[i].getWriteMethod();
                if("username".equals(propName)){
                    // 调用属性的set方法
                    writeMethod.invoke(bean,prop.getProperty("bean.username"));
                }else if("password".equals(propName)){
                    writeMethod.invoke(bean,prop.getProperty("bean.password"));
                }else if("setUrl".equals(propName)){
                    writeMethod.invoke(bean,prop.getProperty("bean.setUrl"));
                }
            }

        } catch (ClassNotFoundException | IntrospectionException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return bean;
    }

}
