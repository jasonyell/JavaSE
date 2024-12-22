package com.Bean;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * @program: ReflectionDemo
 * @description
 * @author: JasonYell
 * @create: 2023-03-06 00:38
 **/
public class BeanTest {
    @Test
    public void test(){
        // 从客户端获取数据是这样
        String name = "bin";
        String age = "18";
        String salary = "20000";

        Emp emp = new Emp();
//        emg.setName(name);

        try {
            BeanUtils.setProperty(emp,"name",name);
            BeanUtils.setProperty(emp,"age",age);
            BeanUtils.setProperty(emp,"salary",salary);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(emp.getInfo());
    }
}
