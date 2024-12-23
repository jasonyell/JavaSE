package com.jason;

/**
 * @program: GenericDemo
 * @description
 *  泛型类
 *   T  参数化类型 在实际使用时才会指定具体的类型
 *   泛型只作用于编译器检查 在编译后没会被擦除
 * @author: JasonYell
 * @create: 2023-03-08 01:00
 **/
public class Node<T> {
    private T data;
    public Node(){

    }

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
