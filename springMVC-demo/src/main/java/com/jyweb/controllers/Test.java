package com.jyweb.controllers;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: springMVC-demo
 * @description
 * @author: JasonYell
 * @create: 2024-08-21 01:03
 **/
public class Test {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            Socket socket = serverSocket.accept();

            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String str = null;
            while((str=br.readLine())!=null){
                System.out.println(str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
