package com.jason.JSON;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: XmlAndJsonDemo
 * @description
 * @author: JasonYell
 * @create: 2023-03-16 01:06
 **/
public class JSONDemo3 {
    /**
     * 把一组JSON对象转换成Java对象集合，或者把java对象集合转化成JSON
     */
    @Test
    public void gson2(){
        Gson gson = new Gson();

        InputStream is = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/jason/File/name.json");
        InputStreamReader in = new InputStreamReader(is);

        TypeToken<List<Name>> typeToken = new TypeToken<List<Name>>() {
        };

        List<Name> list = gson.fromJson(in, typeToken.getType());
        System.out.println(list);
        System.out.println("=============================================================");
        String s = gson.toJson(list, typeToken.getType());
        System.out.println(s);


    }

    /**
     * 把一个JSON对象转换成java对象，火把一个java对象转换成JSON对象
     */
    @Test
    public void gson1(){
        Gson gson = new Gson();

        InputStream is = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/jason/File/name1.json");
        InputStreamReader in = new InputStreamReader(is);

        Name name1 = gson.fromJson(in, Name.class);
        System.out.println(name1);

        String json = gson.toJson(name1);
        System.out.println(json);
    }

    // 创建JSON对象
    @Test
    public void createJSON(){
        List<Name> list = new ArrayList<>();
        list.add(new Name("jason","yell","12344444"));
        list.add(new Name("Silence","AI","12344444"));
        JsonArray array = new JsonArray();

        for(Name n : list){
            JsonObject obj = new JsonObject();

            obj.addProperty("firstName",n.getFirstName());
            obj.addProperty("lastName",n.getLastName());
            obj.addProperty("email",n.getEmail());

            array.add(obj);
        }
        System.out.println(array);
    }
}
