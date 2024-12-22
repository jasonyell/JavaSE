package com.AOP;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: ReflectionDemo
 * @description
 * @author: JasonYell
 * @create: 2023-03-07 01:28
 **/
public class ProxyFactoryBean implements InvocationHandler {
    private Object target;
    private Advice advice;

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public Object getProxy(){
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);
        return proxy;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        advice.beforeAdvice();
        Object obj = method.invoke(target, args);
        advice.afterAdvice();
        return obj;
    }
}
