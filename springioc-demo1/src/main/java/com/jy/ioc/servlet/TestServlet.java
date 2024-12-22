package com.jy.ioc.servlet;

import com.jy.ioc.service.ProductService;

/**
 * @program: springioc-demo1
 * @description
 * @author: JasonYell
 * @create: 2024-08-12 00:34
 **/
public class TestServlet {

    private ProductService productService;

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public void doGet(){
        doPost();
    }

    public void doPost(){
        productService.listProducts();
    }
}
