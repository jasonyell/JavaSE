package com.Proxy;

import org.junit.Test;

/**
 * @program: ReflectionDemo
 * @description
 * @author: JasonYell
 * @create: 2023-03-03 01:09
 **/
public class TestDemo {
    public static void main(String[] args) {

    }

    @Test
    public void testProxy(){
        CreateProxy createProxy = new CreateProxy(); // 创建代理对象的对象
        Subject person = new Person();
        Subject object = (Subject) createProxy.create(person);
        object.shopping(); // invoke

        // 代理多个接口
        Hotel person1 = new Person();
        Hotel object1 = (Hotel) createProxy.create(person1);
        object1.reserve();

    }

}
