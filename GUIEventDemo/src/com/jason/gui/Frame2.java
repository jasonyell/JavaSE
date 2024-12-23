package com.jason.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @program: GUIEventDemo
 * @description
 *  接口回调：
 *      当一个对象需要给外部对象提供数据时，我们可以定义一个内部接口把数据通过接口传递出去
 *      所有外部对象需要数据时，实现这个接口
 *      好处：传递数据的对象不直接依赖接受数据的对象 降低耦合性
 * @author: JasonYell
 * @create: 2023-03-17 00:11
 **/
public class Frame2 extends Frame {

    private TextField textField = new TextField(20);
    private Button button = new Button("付款");

    public Frame2() throws HeadlessException {
        this.setSize(400,200);
        this.setLayout(new FlowLayout());
        this.add(textField);
        this.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String money = textField.getText();
                moneyListener.setMoney(money);
            }
        });
        this.setVisible(true);
    }

    private MoneyListener moneyListener;

    public void setMoneyListener(MoneyListener moneyListener) {
        this.moneyListener = moneyListener;
    }

    public static interface MoneyListener{
         void setMoney(String money);
    }

}
