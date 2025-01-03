package com.jason.SAXxml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Xpp3DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @program: XmlAndJsonDemo
 * @description
 *
 * @author: JasonYell
 * @create: 2023-03-12 01:39
 **/
public class XMLDemo {

    /**
     * 使用第三方xStream组件实现XML的解析与生成
     */
    @Test
    public void xStream(){
        Person p = new Person();

        p.setPersonid("1234");
        p.setAddress("北京");
        p.setFax("d123q");
        p.setTel("12345666");
        p.setEmail("ssssssssssssssssss");
        p.setName("38383838");

        XStream xStream = new XStream(new Xpp3DomDriver());
        //由于对象默认开启安全防护，添加这条语句解决问题。尽量限制最低权限。
        xStream.addPermission(AnyTypePermission.ANY);

        xStream.alias("person",Person.class);
        xStream.useAttributeFor(Person.class,"personid");
        String xml= xStream.toXML(p);
        System.out.println(xml);

//        解析XML
        Person person = (Person) xStream.fromXML(xml);
        System.out.println(person);
    }

    /**
     * 读取XML文件
     */
    @Test
    public void xmlDeCoder() throws FileNotFoundException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("test.xml"));
        XMLDecoder xmlDecoder = new XMLDecoder(bis);
        Person person = (Person) xmlDecoder.readObject();
        System.out.println(person);
    }

    /**
     * 把对象转化成XML
     */
    @Test
    public void XMLenCoder() throws FileNotFoundException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("test.xml"));
        XMLEncoder xmlEncoder = new XMLEncoder(bos);
        Person p = new Person();
        p.setPersonid("1234");
        p.setAddress("北京");
        p.setFax("d123q");
        p.setTel("12345666");
        p.setEmail("ssssssssssssssssss");
        p.setName("38383838");
        xmlEncoder.writeObject(p);
        xmlEncoder.close();
    }

    /**
     * DOM4J解析XML
     * 基于树形结构，第三方组件
     * 解析速度快，效率更高，使用的java中的迭代器实现数据读取，在web框架中使用更多
     */
    @Test
    public void dom4jParseXMG() throws DocumentException {
        // 创建dom4j的解析器对象
        SAXReader reader = new SAXReader();

        InputStream is = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/jason/SAXxml/Person.xml");

        org.dom4j.Document doc = reader.read(is);

        org.dom4j.Element rootElement = doc.getRootElement();

        Iterator<org.dom4j.Element> iterator = rootElement.elementIterator();

        ArrayList<Person> persons = new ArrayList<>();

        Person p = null;

        while(iterator.hasNext()){

            p = new Person();

            org.dom4j.Element e = iterator.next();

            p.setPersonid(e.attributeValue("personid"));

            Iterator<org.dom4j.Element> iterator1 = e.elementIterator();

            while(iterator1.hasNext()){
                org.dom4j.Element next = iterator1.next();
                String tag = next.getName();

                if ("name".equals(tag)) {
                    p.setName(next.getText());
                } else if ("fax".equals(tag)) {
                    p.setFax(next.getText());
                } else if ("address".equals(tag)) {
                    p.setAddress(next.getText());
                } else if ("email".equals(tag)) {
                    p.setEmail(next.getText());
                }
            }
            persons.add(p);
        }
        System.out.println("结果：");
        System.out.println(Arrays.toString(persons.toArray()));
    }

    /**
     *JDOM解析 XML
     * 1.与DOM类似 都是使用树型结构
     * 与DOM区别：
     *  1. 第三方开源组件
     *  2. 实现使用Java的collection接口
     *  3. 效率比DOM更快
     */
    @Test
    public void jdomParseXML() throws JDOMException, IOException {
        // 创建JDOM解析器
        SAXBuilder builder = new SAXBuilder();
        InputStream is = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/jason/SAXxml/Person.xml");

        org.jdom2.Document build = builder.build(is);

        Element rootElement = build.getRootElement();

        List<Person> list = new ArrayList<>();
        Person person = null;
        List<Element> children = rootElement.getChildren();

        for(Element element :children){
            person = new Person();
            String personid = element.getAttributeValue("personid");
            person.setPersonid(personid);
            List<Element> children1 = element.getChildren();

            for(Element element1 : children1) {
                String tag = element1.getName();
                if ("name".equals(tag)) {
                    person.setName(element1.getText());
                } else if ("fax".equals(tag)) {
                    person.setFax(element1.getText());
                } else if ("address".equals(tag)) {
                    person.setAddress(element1.getText());
                } else if ("email".equals(tag)) {
                    person.setEmail(element1.getText());
                }
                list.add(person);
            }
        }
        System.out.println("结果：");
        System.out.println(Arrays.toString(list.toArray()));
    }

    /**
     * DOM解析XML
     *  1.基于树形结构，通过解析器一次性把文档加载到内存中，所以会比较占用内存，
     *  可以随机访问，更加灵活适用于web开发
     *
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    @Test
    public void domParseXML() throws ParserConfigurationException, IOException, SAXException {
        // 创建一个DOM解析器工厂对象
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // 通过工厂对象创建解析器对象
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        // 解析文档
        InputStream is = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/jason/SAXxml/Person.xml");
        // 此代码完成后，整个XML文档已经被加载到内存中，以树状形式存储
        Document doc = documentBuilder.parse(is);
        // 从内存中读取数据

        // 获取节点名称为person的所有节点，返回节点集合
        NodeList personNodeList = doc.getElementsByTagName("person");
        ArrayList<Person> persons = new ArrayList<>();
        Person p = null;

        // 次循环迭代两次
        for (int i = 0; i<personNodeList.getLength(); i++){
            Node personNode = personNodeList.item(i);
            p = new Person();
            // 获取节点属性
            String personid = personNode.getAttributes().getNamedItem("personid").getNodeValue();
            p.setPersonid(personid);
            // 获取当前及结点的所有子节点
            NodeList childNodes = personNode.getChildNodes();
            for (int j = 0; j < childNodes.getLength(); j++) {
                Node item = childNodes.item(j);
                String nodeName = item.getNodeName();
                if("name".equals(nodeName)){
                    p.setName(item.getFirstChild().getNodeValue());
                }else if("address".equals(nodeName)){
                    p.setName(item.getFirstChild().getNodeValue());
                }else if("tel".equals(nodeName)){
                    p.setName(item.getFirstChild().getNodeValue());
                }else if("fax".equals(nodeName)) {
                    p.setName(item.getFirstChild().getNodeValue());
                }else if("email".equals(nodeName)) {
                    p.setName(item.getFirstChild().getNodeValue());
                }
            }
            persons.add(p);
        }
        System.out.println("结果：");
        System.out.println(Arrays.toString(persons.toArray()));
    }


    @Test
    public void saxParseXML(){
        //1.创建一个SAX解析器工厂对象
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        //2.通过工厂对象创建SAX解析器
        try {
            SAXParser saxParser = parserFactory.newSAXParser();

            //3.创建一个数据处理器
            PersonHandle personHandle = new PersonHandle();

            //4.开始解析
            InputStream is = Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream("com/jason/SAXxml/Person.xml");

            saxParser.parse(is,personHandle);

            List<Person> persons = personHandle.getPersons();
            for (Person p : persons) {
                System.out.println(p);
            }

        } catch (ParserConfigurationException | IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

    }
}
