package com.jason.gui;

import java.awt.*;
import java.awt.event.*;

/**
 * @program: GUIEventDemo
 * @description
 * @author: JasonYell
 * @create: 2023-03-16 23:50
 **/
public class MyFrame extends Frame implements ActionListener {
    public MyFrame() throws HeadlessException {
        this.setSize(600,400);
        this.setTitle("我的第一个GUI窗体");
        // 创建一个按钮
        Button button = new Button("点我一下,有惊喜");

        // 给按钮添加单击事件
        button.addActionListener(this);

        //  创建一个线性布局
        FlowLayout flowLayout = new FlowLayout();
        this.setLayout(flowLayout);

        // 给窗口添加关闭事件
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });

        // 把按钮创建到窗体上
        this.add(button);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MyFrame();
    }

    // 单击事件处理的方法
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("惊喜来了");
    }
}
