package com.jason.JSON;

import com.google.gson.stream.JsonReader;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: XmlAndJsonDemo
 * @description
 * @author: JasonYell
 * @create: 2023-03-15 00:12
 **/
public class JSONDemo1 {
    /**
     * 解析一个JSON数组
     *
     */
    @Test
    public void parseJSONNames(){
        InputStream in = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/jason/File/name.json");
        InputStreamReader isr = new InputStreamReader(in);
        // JSON的解析工具(解析器)
        JsonReader reader = new JsonReader(isr);
        ArrayList<Name> list = new ArrayList<>();

        try {
            // 开始解析JSON数组
            reader.beginArray();

            while(reader.hasNext()){
                list.add(parseName(reader));
            }

            // 结束解析JSON数组
            reader.endArray();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(Arrays.toString(list.toArray()));
    }

    // 解析对象
    public Name parseName(JsonReader jsonReader)  {
        Name name = null;

        try {
            // 开始解析JSON对象
            jsonReader.beginObject();

            name = new Name();

            while (jsonReader.hasNext()){
                String s = jsonReader.nextName();

                if("firstName".equals(s)){
                    name.setFirstName(jsonReader.nextString());
                }else if("lastName".equals(s)){
                    name.setLastName(jsonReader.nextString());
                }else if("email".equals(s)){
                    name.setEmail(jsonReader.nextString());
                }
            }
            // 结束解析JSON对象
            jsonReader.endObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return name;
    }
}
