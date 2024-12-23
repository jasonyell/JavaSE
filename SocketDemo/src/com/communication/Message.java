package com.communication;

import java.io.Serializable;

/**
 * @program: SocketDemo
 * @description
 *  消息包
 * @author: JasonYell
 * @create: 2023-02-28 01:22
 **/
public class Message implements Serializable {
    private String form; // 发送者
    private String to;   // 接受者
    private int type;    // 消息类型
    private String info; // 消息

    public Message() {
    }

    public Message(String form, String to, int type, String info) {
        this.form = form;
        this.to = to;
        this.type = type;
        this.info = info;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getForm() {
        return form;
    }

    public String getTo() {
        return to;
    }

    public int getType() {
        return type;
    }

    public String getInfo() {
        return info;
    }
}
