package com.jy.utility;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @program: spring-aop-demo3
 * @description
 * @author: JasonYell
 * @create: 2024-08-18 17:18
 **/
@Component
@Aspect
public class TransactionManager {

    @Pointcut("execution(* com.jy.DAO.*.*(..))")
    public void pc1(){}

//    @Before("execution(* com.jy.DAO.*.*(..))")
    @Before("pc1()")
    public void begin(){
        System.out.println("~~~~start commit");
    }

//    @After("execution(* com.jy.DAO.*.*(..))")
    @After("pc1()")
    public void commit(){
        System.out.println("~~~~end commit");
    }

    @Around("pc1()")
    public Object printExecuteTime(ProceedingJoinPoint point) throws Throwable {
        long time1 = System.currentTimeMillis();
        Object o = point.proceed();
        long time2 = System.currentTimeMillis();
        System.out.println("-----time: "+(time2-time1));
        return o;
    }

}
