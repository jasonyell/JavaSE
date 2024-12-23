package com.communication;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: SocketDemo
 * @description
 *  服务器端
 * @author: JasonYell
 * @create: 2023-02-28 01:19
 **/
public class Server {
    public static void main(String[] args) {
        // 这个集合保护客户端处的线程
        Vector<UserThread> vector = new Vector<>();

        ExecutorService es = Executors.newFixedThreadPool(5);

        // 创建服务器端的Socket
        try {
            ServerSocket server = new ServerSocket(8888);
            System.out.println("服务器已经启动。。。，等待连接");
            while(true){
                Socket s = server.accept();
                UserThread user = new UserThread(s,vector);
                es.execute(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


/**
 * 客户端处理的线程
 */
class UserThread implements Runnable{
    private String name; // 唯一客户端的名字
    private Socket s;
    private Vector<UserThread> vector; // 客户端处线程的集合
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private boolean flag = true;


    public UserThread(Socket s, Vector<UserThread> vector){
        this.s=s;
        this.vector=vector;
        vector.add(this);
    }

    @Override
    public void run() {

        try {
            System.out.println("客户端"+s.getInetAddress().getHostAddress()+"已连接");
            ois = new ObjectInputStream(s.getInputStream());
            oos = new ObjectOutputStream(s.getOutputStream());

            while(flag){
                // 读取消息对象
                Message msg = (Message) ois.readObject();
                int type = msg.getType();
                switch (type){
                    case MessageType.TYPE_LOGIN:
                        name = msg.getForm();
                        msg.setInfo("欢迎你：");
                        oos.writeObject(msg);
                        break;
                    case MessageType.TYPE_SEND:
                        String to = msg.getTo();
                        UserThread ut;
                        int size = vector.size();
                        for (int i = 0; i < size; i++) {
                            ut = vector.get(i);
                            if(to.equals(ut.name) && ut!=this){
                                ut.oos.writeObject(msg);
                                break;
                            }
                        }
                        break;
                }

            }
            ois.close();
            oos.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
