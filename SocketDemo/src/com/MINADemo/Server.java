package com.MINADemo;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.SocketAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * @program: SocketDemo
 * @description
 * @author: JasonYell
 * @create: 2023-03-01 01:26
 **/
public class Server {
    public static void main(String[] args) {

        //创建一个非阻塞的sever端 NIO
        SocketAcceptor acceptor = new NioSocketAcceptor();
        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
        //设定一个过滤器，一行一行的读取数据（/r/n)
        chain.addLast("myChain",new ProtocolCodecFilter(new TextLineCodecFactory()));
        // 设置服务器端的消息处理器
        acceptor.setHandler(new MinaServerHandler());
        int port = 9999;  // 服务器端口号
        try {
            //绑定端口，启动服务器（不会阻塞，立即返回）
            acceptor.bind(new InetSocketAddress(port));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Mina Server running, listener on:" + port);
    }
}
