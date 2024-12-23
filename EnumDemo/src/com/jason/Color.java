package com.jason;

/**
 * @program: EnumDemo
 * @description
 *  定义一个枚举类型
 * @author: JasonYell
 * @create: 2023-03-09 23:58
 **/
public enum Color  implements Info{
    RED(10){
        @Override
        public int getColor2() {
            return 10;
        }
    }, GREEN(20){
        @Override
        public int getColor2() {
            return 20;
        }
    }, BLUE(30){
        @Override
        public int getColor2() {
            return 30;
        }
    };
    private int color;
    private Color(){
        System.out.println("无参构造器");
    };
    private Color(int color){
        this.color=color;
        System.out.println("有参数构造器");
    }

    @Override
    public int getColor() {
        return color;
    }

    public abstract int getColor2();
}
