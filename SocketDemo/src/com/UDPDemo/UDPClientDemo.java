package com.UDPDemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @program: SocketDemo
 * @description
 * @author: JasonYell
 * @create: 2023-03-01 00:24
 **/
public class UDPClientDemo {
    public static void main(String[] args) {

        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes,bytes.length);

        try {
            DatagramSocket socket = new DatagramSocket(8000);
            System.out.println("正在接受数据中。。。");
            socket.receive(dp);  // 接受数据
            String s = new String(dp.getData(),0,dp.getLength());
            System.out.println(s);
            socket.close();

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
