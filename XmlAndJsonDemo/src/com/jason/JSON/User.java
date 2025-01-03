package com.jason.JSON;

/**
 * @program: XmlAndJsonDemo
 * @description
 * @author: JasonYell
 * @create: 2023-03-15 00:58
 **/
public class User {
    private String name;
    private int followers_count;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", followers_count=" + followers_count +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFollowers_count() {
        return followers_count;
    }

    public void setFollowers_count(int followers_count) {
        this.followers_count = followers_count;
    }
}
