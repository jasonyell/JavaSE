package com.AOP;

/**
 * @program: ReflectionDemo
 * @description
 *  切面的实现类
 * @author: JasonYell
 * @create: 2023-03-07 01:25
 **/
public class LogAdvice implements Advice {
    @Override
    public void beforeAdvice() {
        System.out.println("start time" + System.currentTimeMillis());
    }

    @Override
    public void afterAdvice() {
        System.out.println("end time" + System.currentTimeMillis());
    }
}
