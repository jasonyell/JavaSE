package com.jyweb.bean;

/**
 * @program: springMVC-demo2
 * @description
 * @author: JasonYell
 * @create: 2024-08-27 01:27
 **/
public class Book {
    private int bookId;
    private String bookName;
    private String bookAuthor;
    private double bookPrice;
    private String bookImg;

    public Book() {
    }

    public Book(int bookId, String bookName, String bookAuthor, double bookPrice, String bookImg) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPrice = bookPrice;
        this.bookImg = bookImg;
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

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookImg() {
        return bookImg;
    }

    public void setBookImg(String bookImg) {
        this.bookImg = bookImg;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookPrice=" + bookPrice +
                ", bookImg='" + bookImg + '\'' +
                '}';
    }
}
