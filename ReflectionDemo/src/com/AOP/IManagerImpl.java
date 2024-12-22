package com.AOP;

import java.util.ArrayList;

/**
 * @program: ReflectionDemo
 * @description
 * @author: JasonYell
 * @create: 2023-03-07 01:19
 **/
public class IManagerImpl implements IManager {
    private ArrayList<String> list = new ArrayList<>();
    @Override
    public void add(String item) {
//        System.out.println("add start...."+System.currentTimeMillis());
        list.add(item);
        System.out.println(item.toString());
//        System.out.println("add end...."+System.currentTimeMillis());
    }
}
