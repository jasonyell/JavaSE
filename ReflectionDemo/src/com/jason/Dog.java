package com.jason;

/**
 * @program: ReflectionDemo
 * @description
 * @author: JasonYell
 * @create: 2023-03-02 00:54
 **/
public class Dog {
    public int age1;
    private String name;
    private String sex;
    private int age;

    public Dog() {
    }

    public Dog(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "age1=" + age1 +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
