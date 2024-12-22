package com.jy.ioc.test;

import com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderImpl;

import javax.xml.parsers.DocumentBuilder;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @program: springioc-demo1
 * @description
 * @author: JasonYell
 * @create: 2024-08-11 00:23
 **/
public class Test3 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        
        
        String classPath = "com.jy.ioc.beans.Student";
//        String classPath = "com.jy.ioc.beans.Book";

        // 通过反射创建对象
        Class<?> c = Class.forName(classPath);

        // 通过反射创建对象
        Object obj =  c.newInstance();

        // 通过反射获取类的属性
        Field[] declaredFields = c.getDeclaredFields();

        for (Field f: declaredFields) {

            String fieldName = f.getName(); // stuNum ---- setStuName

            String setMethodName = "set" + fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);

            if("stuNum".equals(fieldName)){
                // 1001
                Method setMethod = c.getDeclaredMethod(setMethodName, f.getType());
                setMethod.invoke(obj,"1001");

            }


            System.out.println(fieldName + "-------" + setMethodName);
        }


        
        System.out.println(obj);
    }
}
