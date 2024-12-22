package com.jy.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.Date;

/**
 * @program: springIoC-demo2
 * @description
 * @author: JasonYell
 * @create: 2024-08-12 01:32
 **/
@Component(value = "stu")
@Scope(value = "singleton")
@Lazy(true)
public class Student {

    private String stuNum;
    private String stuName;
    private String stuGender;
    private int stuAge;
    private Date enterenceTime;

//    @Autowired(required = false)
    @Resource(shareable = false)
    private Clazz clazz;

    private Books books;

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public void setStuGender(String stuGender) {
        this.stuGender = stuGender;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }

    public void setEnterenceTime(Date enterenceTime) {
        this.enterenceTime = enterenceTime;
    }

    @Autowired
    public void setClazz(@Qualifier("c1") Clazz clazz) {
        this.clazz = clazz;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    public Student() {
        System.out.println("创建类");
    }

    @PostConstruct
    public void init(){
        System.out.println("init");
    }

    @PreDestroy
    public void destory(){
        System.out.println("destory");
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuNum='" + stuNum + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuGender='" + stuGender + '\'' +
                ", stuAge=" + stuAge +
                ", enterenceTime=" + enterenceTime +
                ", clazz=" + clazz +
                ", books=" + books +
                '}';
    }

}
