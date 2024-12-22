package com.jy.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @program: spring-aop-demo2
 * @description
 * @author: JasonYell
 * @create: 2024-08-18 16:39
 **/
public class MyAspect {

    public void method1(){
        System.out.println("method1==========");
    }

    public void method2(){
        System.out.println("method2==========");
    }

    public void method3(){
        System.out.println("method3==========");
    }

    public void method4(){
        System.out.println("method4==========");
    }

    /**
     * 环绕通知的切入点方法，必须遵守如下的定义规则
     * 1.必须带有一个参数
     * 2.必须有obj类型的返回值
     * 3.前后增强的业务逻辑之间执行 Object o = point.proceed();
     * 4.最后返回o
     */
    public Object method5(ProceedingJoinPoint point) throws Throwable {
        System.out.println("method5==========before");
        // 此代码的执行，就代表切入点方法的执行
        Object o = point.proceed();
        System.out.println("method5==========after");
        return o;
    }

}
