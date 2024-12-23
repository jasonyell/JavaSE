package com.UDPDemo;

import java.io.IOException;
import java.net.*;

/**
 * @program: SocketDemo
 * @description
 * @author: JasonYell
 * @create: 2023-03-01 00:17
 **/
public class UDPServerDemo {
    public static void main(String[] args) throws IOException {
        String info = "good good study, 天天 up";
        byte[] bytes = info.getBytes();
        /**
         * buf - 数据包数据
         * offset - 分组数据偏移量
         * length - 分组数据长度
         * address - 目的地址
         * port - 目的端口号
         */
        try {
            DatagramPacket dp = new DatagramPacket(
                    bytes, 0, bytes.length, InetAddress.getByName("127.0.0.1"),8000);

            // 本程序的端口
            DatagramSocket socket = new DatagramSocket(9000);
            socket.send(dp);
        } catch (UnknownHostException | SocketException e) {
            e.printStackTrace();
        }
    }
}
