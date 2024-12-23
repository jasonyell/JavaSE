package com.jason.SAXxml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: XmlAndJsonDemo
 * @description
 *  SAX解析的特点：
 *      1.基于时间驱动
 *      2.顺序读取 速度快
 *      3.不能任意读取节点（灵活性差）
 *      4.解析时占用的内存小
 *      5.SAX更是用于在性能要求更高的设备上使用（Android开发中）
 * @author: JasonYell
 * @create: 2023-03-12 01:43
 **/
public class PersonHandle extends DefaultHandler {

    private List<Person> persons = null;
    // 当前正在解析的Person
    private Person p;
    // 用于记录当前正在解析的标签名
    private String tag;

    public List<Person> getPersons() {
        return persons;
    }

    /**
     * 开始解析文档时调用
     * @throws SAXException
     */
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        persons = new ArrayList<>();
        System.out.println("开始解析文档。。。");

    }

    /**
     * 结束文档解析
     * @throws SAXException
     */
    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("文档解析结束。。。");
    }

    /**
     * 解析开始元素时调用
     * @param uri        命名空间
     * @param localName  不带前缀的标签名  <person><person/>
     * @param qName      带前缀标签名     <aa:person></aa:person>
     * @param attributes 当前那标签的属性集合
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if("person".equals(qName)){
            p = new Person();
            String personid = attributes.getValue("personid");
            p.setPersonid(personid);
        }
        tag = qName;
    }


    /**
     * 解析结束元素（标签）时调用
     * @param uri
     * @param localName
     * @param qName
     * @throws SAXException
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if ("person".equals(qName)) {
            persons.add(p);
        }
        tag = null;
    }

    /**
     * 解析文本内容时调用
     * @param ch
     * @param start
     * @param length
     * @throws SAXException
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        if (tag != null){
            if ("name".equals(tag)) {
                p.setName(new String(ch,start,length));
            }else if("address".equals(tag)){
                p.setAddress(new String(ch,start,length));
            }else if("tet".equals(tag)){
                p.setTel(new String(ch,start,length));
            }else if("fax".equals(tag)){
                p.setFax(new String(ch,start,length));
            }else if("email".equals(tag)){
                p.setEmail(new String(ch,start,length));
            }
        }
    }
}
