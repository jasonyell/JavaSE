package com.jason.utils;

import com.jason.bean.Clothes;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Xpp3Driver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: ClothesSupermarketSystem
 * @description
 * @author: JasonYell
 * @create: 2023-03-22 00:26
 **/
public class ProductsXmlUtils {


    public static List<Clothes> parserProductFormXml() {

        List<Clothes> products = new ArrayList<>();

        XStream xStream = new XStream(new Xpp3Driver());
        xStream.addPermission(AnyTypePermission.ANY);

        xStream.alias("list",products.getClass());
        xStream.alias("clothes",Clothes.class);
        xStream.useAttributeFor(Clothes.class,"id");

        try {
            BufferedInputStream inputStream = new BufferedInputStream(
                    new FileInputStream("H:\\Jason\\IdeaProjects\\ClothesSupermarketSystem\\src\\com\\products.xml"));

            products = (List<Clothes>) xStream.fromXML(inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return products;
    }

    public static void writeProductToXml(List<Clothes> products){

        XStream xStream = new XStream(new Xpp3Driver());
        xStream.addPermission(AnyTypePermission.ANY);

        xStream.alias("list",products.getClass());
        xStream.alias("clothes",Clothes.class);
        xStream.useAttributeFor(Clothes.class,"id");

        try {
            BufferedOutputStream outputStream = new BufferedOutputStream(
                    new FileOutputStream("com/products.xml"));

            outputStream.write("<?xml version=\"1.0\" encoding=\"utf-8\" ?>".getBytes());
            xStream.toXML(products,outputStream);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
