package com.jyweb.controller;

import com.jyweb.bean.Book;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @program: springMVC-demo2
 * @description
 * @author: JasonYell
 * @create: 2024-08-27 01:10
 **/
@Controller
@RequestMapping("/book")
public class BookController {


    @RequestMapping("/add")
    public String addBook(Book book, MultipartFile bookImage, HttpServletRequest request) throws IOException {
        System.out.println("--------------------add");

        // bookImage 就表示上传的图片
        // 1. 截取上传文件后缀名,生成新的文件名
        String originalFilename = bookImage.getOriginalFilename();
        String ext = originalFilename.substring(originalFilename.lastIndexOf(".")); // .JPG
        String fileName = System.currentTimeMillis()+ext;

        // 2. 获取img目录在服务器的路径
        String dir = request.getServletContext().getRealPath("img");
        String savePath = dir+"/"+fileName;

        // 3. 保存文件
        bookImage.transferTo(new File(savePath));

        // 4.将图片的访问路径到book对象
        book.setBookImg("img/"+fileName);

        // 5.调用service保存book到数据库


        return "/tips.jsp";
    }

    @RequestMapping("/list")
    @ResponseBody
    public String[] listImgs(HttpServletRequest request){
        // 1. 从img目录下获取所有的图片信息
        String dir = request.getServletContext().getRealPath("/img");
        File imgDir = new File(dir);
        String[] fileName = imgDir.list();
        return fileName;
    }

    @RequestMapping("/download")
    public void downLoadImg(String fname, HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 从img目录中找到当前文件
        String dir = request.getServletContext().getRealPath("/img");
        String filePath = dir+"/"+fname;

        FileInputStream fileInputStream = new FileInputStream(filePath);

        response.setContentType("application/pdf");
        response.addHeader("content-disposition","attachment;filename"+fname);

        IOUtils.copy(fileInputStream,response.getOutputStream());
    }

    @RequestMapping("/query")
    public String query(String num){
        int num1 = Integer.parseInt(num);
        System.out.println(num1);
        return "/tips.jsp";
    }

}
