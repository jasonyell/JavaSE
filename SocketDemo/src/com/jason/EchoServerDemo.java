package com.jason;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: SocketDemo
 * @description
 * @author: JasonYell
 * @create: 2023-02-28 00:41
 **/
public class EchoServerDemo {

    public static void main(String[] args) {
        // 创建一个服务器端的Socket（可用port区间：1024 - 65535）
        try {
            ServerSocket server = new ServerSocket(6666);
            System.out.println("服务器已经启动。。。");

            // 等待客户端的连接，造成阻塞，如果有客户端连接成功，立即返回一个Socket对象
            Socket socket = server.accept();
            System.out.println("客户端连接成功"+socket.getInetAddress().getHostAddress());
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            //通过输入流读取网络数据
            //如果没有数据 也会造成阻塞
            String info = br.readLine();
            System.out.println(info);

            PrintStream ps = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));

            ps.println("echo"+info);
            ps.flush();
            // 关闭
            ps.close();
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
