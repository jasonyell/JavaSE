package com.jason;

import java.util.Arrays;

/**
 * @program: AnnotationDemo
 * @description
 * @author: JasonYell
 * @create: 2023-03-10 00:36
 **/
@MyAnnotation(name="bin",age=4,food = {"fish","apple"},color = Color.RED)
public class Cat {
    private String name;
    private int age;

    public void setColor(Color color) {
        this.color = color;
    }

    public void setFood(String[] food) {
        this.food = food;
    }

    private Color color;
    private String[] food;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // 用于验证方法是否覆盖父类中的方法
    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age + ", color="+ color +
                ", food="+ Arrays.toString(food) +
                '}';
    }

    // 用于标记方法已过时 不建议使用
    @Deprecated
    public String printInfo(){
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Cat() {

    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
