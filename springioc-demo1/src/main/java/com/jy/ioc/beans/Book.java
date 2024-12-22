package com.jy.ioc.beans;

/**
 * @program: springioc-demo1
 * @description
 * @author: JasonYell
 * @create: 2024-08-11 00:10
 **/
public class Book {

    private int bookId;
    private String bookName;

    public void iniz(){
        // 初始化方法，创建当前对象是调用的方法，进行资源准备工作
        System.out.println("iniz-----------");
        this.bookId = 1;
        this.bookName = "初始值";
    }

    public void destory(){
        // 销毁方法：在spring容器销毁对象时调用此方法，进行一些资源回收性的操作
        System.out.println("destory-----------");
    }

    public Book(){
        System.out.println("------------------");
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                '}';
    }
}
