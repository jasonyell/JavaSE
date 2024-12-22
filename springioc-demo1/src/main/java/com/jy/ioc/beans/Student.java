package com.jy.ioc.beans;

import java.util.*;

/**
 * @program: springioc-demo1
 * @description
 * @author: JasonYell
 * @create: 2024-08-10 02:06
 **/
public class Student {

    private String stuNum;
    private String stuName;
    private String stuGender;
    private double weight;
    private int stuAge;
    private Date enterenceTime;                      //入学日期
    private Clazz clazz;

    public Student() {
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public Student(String stuNum, String stuName, String stuGender, double weight, int stuAge, Date enterenceTime, Clazz clazz) {
        this.stuNum = stuNum;
        this.stuName = stuName;
        this.stuGender = stuGender;
        this.weight = weight;
        this.stuAge = stuAge;
        this.enterenceTime = enterenceTime;
        this.clazz = clazz;
    }

    private List<String> list;
    private Set<String> set;
    private Map<String,Object> map;
    private Properties properties;

    public Student(List<String> list, Set<String> set, Map<String, Object> map, Properties properties) {
        this.list = list;
        this.set = set;
        this.map = map;
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuNum='" + stuNum + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuGender='" + stuGender + '\'' +
                ", weight=" + weight +
                ", stuAge=" + stuAge +
                ", enterenceTime=" + enterenceTime +
                ", clazz=" + clazz +
                ", list=" + list +
                ", set=" + set +
                ", map=" + map +
                ", properties=" + properties +
                '}';
    }
}
