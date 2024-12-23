package com.jason;

import org.junit.Test;

import java.util.*;

/**
 * @program: GenericDemo
 * @description
 * @author: JasonYell
 * @create: 2023-03-08 00:44
 **/
public class GnericDemo {

    @Test
    public void test5(){
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"jason");
        map.put(2,"vince");

        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for (Map.Entry emtry: entries
             ) {
            System.out.println(emtry.getKey()+ " " +emtry.getValue());
        }
    }

    @Test
    public void test4(){
        String[] arrays = {"jack","lucy","haha"};
        String[] func = func(arrays, 0, 1);
        System.out.println(Arrays.toString(func));
    }

    @Test
    public void test3(){
        Node<Number> n1 = new Node<>(10);
        Node<Integer> n2 = new Node<>(20);
        getData(n1);
//        n1 = n2 ;  不支持 会报错

        getData2(n1);
        getData2(n2);

    }

    public static void getData(Node<Number> node){
        System.out.println(node.getData());
    }

    public static void getUpperNumberData(Node<? extends Number> data){
        // 只能是Number类及其子类  上限
        System.out.println("data " + data.getData());
    }

    public static void getUpperNumberData2(Node<? super Number> data){
        // 只能是具体类或者父类  下限
        System.out.println("data " + data.getData());
    }

    public static <T> T[] func(T[] array,int i, int j){
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        return array;
    }

    /**
     * 使用通配符 只能接收输出 不能进行修改
     * @param node
     */
    public static void getData2(Node<?> node){
//        node.setData(30);
        System.out.println(node.getData());
    }

    @Test
    public void testNode(){
        Node<String> stringNode = new Node<>("data");
        Node<Integer> integerNode = new Node<>(10);

        System.out.println(stringNode.getData());
        System.out.println(integerNode.getData());
    }

    @Test
    public void test1(){
        List<String> list = new ArrayList();
        list.add("jason");
//        list.add(10);
//        list.add(new Object());

        for (int i = 0; i < list.size(); i++) {
            //  如果不能去确定集合中的元素类型
            //  需要在处理元素时要判断元素类型 才能做相应的操作

        }
    }
}
