<%--
  Created by IntelliJ IDEA.
  User: JasonYell
  Date: 2024/8/20
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

    <h3>表单提交</h3>
    <form action="test/add" method="post">
        <p>图书名称：<input type="text" name="bookName"></p>
        <p>图书作者：<input type="text" name="bookAuthor"></p>
        <p>图书价格：<input type="text" name="bookPrice"></p>
        <p>出版日期：<input type="text" name="publishTime"></p>
        <p><input type="submit" value="提交"></p>
    </form>

    <h3>超链接提交 url提交</h3>
    <a href="book/add?bookName=Java">url 提交</a>

    <h3>AJAX （异步）提交</h3>
    <input type="button" value="ajax submit" id="btn1"/>
    <script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
    <script type="text/javascript">
        $("#btn1").click(function(){
            var obj = {};
            obj.bookName="python";
            obj.bookAuthor="jason";
            obj.bookPrice=3.13;
            var s = JSON.stringify(obj); // 转成JSON格式
            console.log(s);
            $.ajax({
                url:"book/update", // 请求行
                type:"post",
                // headers:{       // 请求头
                //     token:"wahahaha"
                // },
                // 对象数据类型
                contentType:"application/json",
                dataType:"json", // 设置预期服务器返回的数据类型为JSON
                // 请求体
                data:s,   // data 的值为JSON格式字符串，contentType 必须设置为 application/json
                success:function (res) {
                    console.log(res);
                }
            });
        });
    </script>

</body>
</html>
