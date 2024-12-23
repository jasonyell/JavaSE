package com.jason;

import java.lang.annotation.*;

/**
 * @program: AnnotationDemo
 * @description
 *  自定义注解
 * @author: JasonYell
 * @create: 2023-03-10 00:51
 **/
// 用于生成文档
@Documented
// 表示该注解在运行时仍存在
@Retention(RetentionPolicy.RUNTIME)
// 用于表示注解的应用范围(类型？方法？构造器？参数？局部变量？包？Annotation)
@Target(ElementType.TYPE)
// 是否允许子类继承注解
@Inherited
public @interface MyAnnotation {
    // 定义变量
    public String name();
    public int age() default 2;//设置默认值为2

    public String[] food();

    public Color color();// 定义一个枚举类型的变量



}
