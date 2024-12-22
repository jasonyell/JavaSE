package com.introspector;

/**
 * @program: ReflectionDemo
 * @description
 * @author: JasonYell
 * @create: 2023-03-07 00:47
 **/
public class Config {
    private String username;
    private String password;
    private String setUrl;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSetUrl() {
        return setUrl;
    }

    public void setSetUrl(String setUrl) {
        this.setUrl = setUrl;
    }

    public Config() {
    }

    public Config(String name, String password, String setUrl) {
        this.username = name;
        this.password = password;
        this.setUrl = setUrl;
    }

    @Override
    public String toString() {
        return "Config{" +
                "name='" + username + '\'' +
                ", password='" + password + '\'' +
                ", setUrl='" + setUrl + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
