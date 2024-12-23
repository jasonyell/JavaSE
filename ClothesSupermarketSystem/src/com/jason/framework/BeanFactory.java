package com.jason.framework;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

/**
 * @program: ClothesSupermarketSystem
 * @description
 *  创建Bean的Factory类
 * @author: JasonYell
 * @create: 2023-04-18 01:47
 **/
public class BeanFactory {
    private Iterator<Element> iterator = null;
    public static BeanFactory beanFactory = null;

    public static BeanFactory init(){
        if(beanFactory == null){
            synchronized (BeanFactory.class){
                if(beanFactory==null){
                    beanFactory = new BeanFactory("bean.xml");
                }
            }
        }
        return beanFactory;
    }

    private BeanFactory(String xml){
        InputStream is = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream(xml);
        // 创建DOM4J的解析器对象
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(is);
            Element rootElement = document.getRootElement();
            iterator = rootElement.elementIterator();
            is.close();
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }

    public Object getBean(String id){
        while(iterator.hasNext()){
            Element bean = iterator.next();
            // 去标签属性
            String sid = bean.attributeValue("id");
            if(sid.equals(id)){
                String className = bean.attributeValue("class");
                try {
                    return Class.forName(className).newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
