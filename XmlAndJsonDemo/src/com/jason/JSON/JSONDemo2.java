package com.jason.JSON;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.sun.org.apache.regexp.internal.RE;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @program: XmlAndJsonDemo
 * @description
 * @author: JasonYell
 * @create: 2023-03-15 00:42
 **/
public class JSONDemo2 {

    /**
     * 使用JSONREADER 解析复杂的JSON数据
     */
    @Test
    public void parseJSONMessages(){
        InputStream in = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/jason/File/message.json");

        InputStreamReader isr = new InputStreamReader(in);

        JsonReader reader = new JsonReader(isr);

        ArrayList<Message> list = readMessageArray(reader);

        for(Message m : list){
            System.out.println(m);
        }


    }


    private ArrayList<Message> readMessageArray(JsonReader reader) {
        ArrayList<Message> list = new ArrayList<>();

        try {
            reader.beginArray();

            while(reader.hasNext()){
                list.add(readMessage(reader));
            }

            reader.endArray();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    // 解析一个message对象
    private Message readMessage(JsonReader reader) {
        Message message = new Message();

        try {
            reader.beginObject();

            while(reader.hasNext()){
                String name = reader.nextName();
                if("id".equals(name)){
                    message.setId(reader.nextLong());
                }else if("text".equals(name)){
                    message.setText(reader.nextString());
                }else if("geo".equals(name) && reader.peek()!= JsonToken.NULL){
                    message.setGeo(readGeo(reader));
                }else if("user".equals(name)){
                    message.setUser(readUser(reader));
                }else{
                    // 不处理的值跳过
                    reader.skipValue();
                }
            }

            reader.endObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return message;
    }

    private User readUser(JsonReader reader) {
        User user = new User();

        try {
            reader.beginObject();

            while(reader.hasNext()){
                String name = reader.nextName();
                if("name".equals(name)){
                    user.setName(reader.nextString());
                } else if ("followers_count".equals(name)) {
                    user.setFollowers_count(reader.nextInt());
                }else{
                    reader.skipValue();
                }
            }

            reader.endObject();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return user;
    }

    // 解析GEO数组
    private ArrayList<Double> readGeo(JsonReader reader) {
        ArrayList<Double> list = new ArrayList<>();

        try {
            reader.beginArray();

            while(reader.hasNext()){
                list.add(reader.nextDouble());
            }

            reader.endArray();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

}
