package com.MINADemo;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import java.net.InetSocketAddress;
import java.util.Scanner;

/**
 * @program: SocketDemo
 * @description
 * @author: JasonYell
 * @create: 2023-03-01 02:00
 **/
public class Client {
    public static void main(String[] args) {
        // 创建连接
        NioSocketConnector connect = new NioSocketConnector();
        DefaultIoFilterChainBuilder chain = connect.getFilterChain();
        chain.addLast("myChain",new ProtocolCodecFilter(new TextLineCodecFactory()));
        connect.setHandler(new MinaClientHander());
        connect.setConnectTimeoutCheckInterval(10000);
        // 连接服务器
        ConnectFuture cf = connect.connect(new InetSocketAddress("localhost", 9999));
        cf.awaitUninterruptibly();// 等待连接成功
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("请输入：");
            String info = input.nextLine();
            // 发送消息
            cf.getSession().write(info);
        }

//        connect.dispose();


    }
}
