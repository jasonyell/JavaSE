package com.jason;

import org.junit.Test;

import java.lang.annotation.Documented;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: AnnotationDemo
 * @description
 * @author: JasonYell
 * @create: 2023-03-10 00:36
 **/
//关闭不当的编译器警告信息
@SuppressWarnings("all")
public class AnnotationDemo {

    @Test
    public void test2(){
        Class<Cat> catClass = Cat.class;
        // 获取类上应用的制定注解
        MyAnnotation annotation = catClass.getAnnotation(MyAnnotation.class);
        // 获取注解上变量值
        String name = annotation.name();
        int age = annotation.age();
        String[] food = annotation.food();
        Color color = annotation.color();

        try {
            Cat cat = catClass.newInstance();
            cat.setAge(age);
            cat.setName(name);
            cat.setColor(color);
            cat.setFood(food);
            System.out.println(cat);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test(){
        Cat haha = new Cat("haha", 3);
        haha.printInfo();



        List list = new ArrayList<>();
        list.add("jason");
        list.add(10);
        list.add(1112);

    }
}
