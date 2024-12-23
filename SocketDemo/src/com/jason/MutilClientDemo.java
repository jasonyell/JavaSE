package com.jason;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @program: SocketDemo
 * @description
 * @author: JasonYell
 * @create: 2023-02-28 00:48
 **/
public class MutilClientDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //创建一个socket对象,指定要连接的服务器
        try {
            Socket socket = new Socket("Localhost",6666);

            PrintStream ps = new PrintStream(
                    new BufferedOutputStream(socket.getOutputStream()));
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            System.out.print("请输入：");
            String str = sc.nextLine();
            ps.println(str);
            ps.flush();
            // 读取服务器端返回的数据
            String s = br.readLine();
            System.out.println(s);

            ps.close();
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
