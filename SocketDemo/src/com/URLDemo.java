package com;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @program: SocketDemo
 * @description
 * @author: JasonYell
 * @create: 2023-03-01 00:54
 **/
public class URLDemo {
    public static void main(String[] args) {
        /**
         *  URL 统一资源定位符
         */
        try {
            URL url = new URL("https://i.cnblogs.com/articles/edit;postId=17162504");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            BufferedInputStream bis = new BufferedInputStream(con.getInputStream());
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("H:\\FileDemo文件\\net.txt"));
            byte[] byteps = new byte[1024];
            int len = -1;
            while((len = bis.read(byteps))!=-1){
                bos.write(byteps,0,len);
                bos.flush();
            }
            bos.close();
            bis.close();
            System.out.println("load success...");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
