package com.jason.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @program: GUIEventDemo
 * @description
 * @author: JasonYell
 * @create: 2023-03-17 00:06
 **/
public class Frame1 extends Frame implements Frame2.MoneyListener {

    private Label label = new Label("金额 ");
    private Button button = new Button("购买");

    public Frame1() throws HeadlessException {
        this.setSize(400,200);
        this.setLayout(new FlowLayout());
        this.add(label);
        this.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Frame2().setMoneyListener(Frame1.this);
            }
        });
        this.setVisible(true);
    }


    @Override
    public void setMoney(String money) {
        label.setText(money);
    }

    public static void main(String[] args) {
        new Frame1();
    }
}
