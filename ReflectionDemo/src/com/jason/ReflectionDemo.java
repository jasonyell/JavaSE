package com.jason;

import org.junit.Test;

import java.lang.reflect.*;

/**
 * @program: ReflectionDemo
 * @description
 * @author: JasonYell
 * @create: 2023-03-02 00:54
 **/
public class ReflectionDemo {

    /**
     * 包 和 方法信息
     *  .getPackage();
     *  .getMethods()
     */
    @Test
    public void test5(){
        Dog dog = new Dog("wangwang", "man", 1);

        Class<Dog> dogClass = Dog.class;
        // 获取类的包名信息
        Package aPackage = dogClass.getPackage();
//        System.out.println(aPackage.getName());
        // 获取公共方法 ，包括继承的公共方法
        Method[] method = dogClass.getMethods();
        for (int i = 0; i < method.length; i++) {
            System.out.println(method[i]);
            System.out.println("-----------------------------");
            if(method[i].getName().equals("toString")){
                try {
                    String invoke = (String) method[i].invoke(dog);
                    System.out.println(invoke);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        // 访问私有方法,获取到本类中定义的所有方法（不包括父类）
        Method[] declaredMethods = dogClass.getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++) {
            System.out.println(declaredMethods[i].getName());
            if(declaredMethods[i].getName().equals("getName")){

                // 设置 私有方法可以被访问（去除访问修饰符的检查）
                declaredMethods[i].setAccessible(true);

                try {
                    String invoke1 = (String) declaredMethods[i].invoke(dog);
                    System.out.println("invoke1 => "+invoke1);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    /**
     *获取所有的属性
     *  .getFields()            不可获取私有属性
     *  .getDeclaredFields()    可获取所有属性 包括私有
     */
    @Test
    public void test4(){
        Class<Dog> dogClass = Dog.class;
        // 不可获取私有属性
        Field[] fields = dogClass.getFields();
        System.out.println(fields.length);

        //可获取所有属性 包括私有
        Field[] declaredFields = dogClass.getDeclaredFields();
        System.out.println(declaredFields.length);
        for (int i = 0; i < declaredFields.length; i++) {
            int modifiers = declaredFields[i].getModifiers();
            System.out.println(modifiers);
            System.out.println(Modifier.toString(modifiers)+" "+declaredFields[i].getName());
        }
    }


    /**
     * 获取所有构造方法
     *  .getConstructors()
     */
    @Test
    public void test3(){
        Class<Dog> dogClass = Dog.class;
        Constructor<?>[] constructors = dogClass.getConstructors();
        for (int i = 0; i < constructors.length; i++) {
            System.out.println("构造方法名 -> "+constructors[i].getName());
            System.out.println("构造方法参数 -> "+constructors[i].getParameterCount());
        }
        try {
            // 获取一个指定的构造方法
            Constructor<Dog> constructor = dogClass.getConstructor(String.class, String.class, int.class);
            // 调用带参数的构造器 来实例化对象
            Dog dog1 = constructor.newInstance("haha", "woman", 1);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    /**
     * 通过反射实例化对象
     *  .newInstance()
     */
    @Test
    public void test2(){
        Class<Dog> dogClass = Dog.class;
        try {
            // 通过Class 对象实例化对象，调用了默认无参的构造方法
            Dog dog = dogClass.newInstance();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }



    /**
     *  获取 class 对象的三种形式
     *      .forName("com.jason.Dog");
     *      .getClass();
     *      Object.class;
     */
    @Test
    public void test1(){
        // 通过对象的getClass() 方法
        Dog dog1 = new Dog("wangwang","MAN",3);
        Class aClass = dog1.getClass();

        // 通过类.class
        Class dogClass = Dog.class;

        // 通过Class.forName()方法
        try {
            Class aClass1 = Class.forName("com.jason.Dog");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
