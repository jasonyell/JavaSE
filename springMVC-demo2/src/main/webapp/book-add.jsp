<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: JasonYell
  Date: 2024/8/27
  Time: 0:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h4>add book information</h4>
    <form action="book/add" method="post" enctype="multipart/form-data">
        <p>图书名称<input type="text" name="bookName"></input</p>
        <p>图书作者<input type="text" name="bookAuthor"></input</p>
        <p>图书价格<input type="text" name="bookPrice"></input</p>
        <p>图书封面<input type="file" name="bookImage"></input</p>
        <p><input type="submit" value="提交"></input</p>
    </form>

    <%--<img src="img/c.JPG"/>--%>
</body>
</html>
