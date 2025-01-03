package com.jason.JSON;

import java.util.ArrayList;

/**
 * @program: XmlAndJsonDemo
 * @description
 * @author: JasonYell
 * @create: 2023-03-15 00:57
 **/
public class Message {
    private long id;
    private String text;
    private ArrayList<Double> geo;
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<Double> getGeo() {
        return geo;
    }

    public void setGeo(ArrayList<Double> geo) {
        this.geo = geo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", geo=" + geo +
                ", user=" + user +
                '}';
    }
}
