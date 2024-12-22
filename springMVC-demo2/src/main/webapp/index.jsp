<%--
  Created by IntelliJ IDEA.
  User: JasonYell
  Date: 2024/8/27
  Time: 0:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table width="100%" height="700">
        <tr>
            <td width="200" style="border-right: deepskyblue 2px solid; background: rgba(255,0,0,0.1)">
                <ul>
                    <li><a href="book-add.jsp" target="mainFrame">文件上传</a></li>
                    <li><a href="list.jsp" target="mainFrame">文件列表</a></li>

                </ul>
            </td>

            <td>
               <iframe name="mainFrame" width="100%" height="700" frameborder="0"></iframe>
            </td>
        </tr>
    </table>
</body>
</html>
